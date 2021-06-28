package com.segware.javabackendtest.service;
import com.segware.javabackendtest.config.MapperConfig;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.entity.Post;
import com.segware.javabackendtest.exception.PostNotFoundException;
import com.segware.javabackendtest.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    public PostService(PostRepository postRepository, MapperConfig mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    private final PostRepository postRepository;
    private final MapperConfig mapper;

    private Boolean verifyIfPostExists(Long postId) {
        return postRepository.existsById(postId);
    }

    public HttpStatus upvotePost(Long postId) throws PostNotFoundException {
        if (!verifyIfPostExists(postId)) throw new PostNotFoundException(postId);
        Post post = postRepository.getById(postId);
        post.setUpvotes(post.getUpvotes() + 1);
        postRepository.save(post);
        return HttpStatus.OK;
    }

    public PostSummaryDTO createPost(PostDTO postDTO) {
        Post post = mapper.postMapper().toModel(postDTO);
        Post savedPost = postRepository.save(post);
        return mapper.postMapper().toSummaryDTO(savedPost);
    }

    public List<PostSummaryDTO> listAll() {
        return postRepository.findAll()
                .stream()
                .map(mapper.postMapper()::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
