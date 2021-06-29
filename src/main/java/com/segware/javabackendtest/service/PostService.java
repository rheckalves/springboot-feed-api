package com.segware.javabackendtest.service;
import com.segware.javabackendtest.config.FakeSecurityContextConfig;
import com.segware.javabackendtest.config.MapperConfig;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.UpvoteDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.dto.request.response.UpvoteSummaryDTO;
import com.segware.javabackendtest.entity.Post;
import com.segware.javabackendtest.exception.PostNotFoundException;
import com.segware.javabackendtest.exception.UserNotFoundException;
import com.segware.javabackendtest.repository.PostRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    public PostService(PostRepository postRepository, UserService userService, MapperConfig mapper, FakeSecurityContextConfig fakeLogin) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.mapper = mapper;
        this.fakeLogin = fakeLogin;
    }

    private final PostRepository postRepository;
    private final UserService userService;
    private final MapperConfig mapper;
    private final FakeSecurityContextConfig fakeLogin;

    protected Boolean verifyIfPostExists(Long postId) {
        return postRepository.existsById(postId);
    }


    public PostSummaryDTO createPost(PostDTO postDTO) {
        Post post = mapper.postMapper().toModel(postDTO);
        Post savedPost = postRepository.save(post);
        return mapper.postMapper().toSummaryDTO(savedPost);
    }

    public UpvoteSummaryDTO upvotePost(UpvoteDTO upvoteDTO) throws PostNotFoundException, UserNotFoundException {
        Boolean validPost = verifyIfPostExists(upvoteDTO.getPostId());
        Boolean validUser = userService.verifyIfUserExists(upvoteDTO.getUserId());
        if (!validPost) throw new PostNotFoundException(upvoteDTO.getPostId());
        if (!validUser) throw new UserNotFoundException(upvoteDTO.getUserId());
        Post post = postRepository.getById(upvoteDTO.getPostId());
        List<Long> upvotesList = post.getUpvotesUserIds();
        if (upvotesList.contains(fakeLogin.loggedUser().getId())) return null;
        else upvotesList.add(upvoteDTO.getUserId());
        post.setUpvotesUserIds(upvotesList);
        postRepository.save(post);
        if (upvoteDTO.getUserId().equals(fakeLogin.loggedUser().getId())) {
            return new UpvoteSummaryDTO(upvoteDTO.getPostId(), true);
        } else {
            return new UpvoteSummaryDTO(upvoteDTO.getPostId(), false);
        }
    }

    public List<PostSummaryDTO> listAll() {
        return postRepository.findAll()
                .stream()
                .map(mapper.postMapper()::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
