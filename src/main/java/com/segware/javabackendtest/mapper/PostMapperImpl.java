package com.segware.javabackendtest.mapper;
import com.segware.javabackendtest.config.FakeSecurityContextConfig;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.entity.Post;
import com.segware.javabackendtest.repository.PostRepository;

import java.util.List;

public class PostMapperImpl implements PostMapper {

    private final PostRepository postRepository;
    private final FakeSecurityContextConfig fakeLogin;

    public PostMapperImpl(PostRepository postRepository, FakeSecurityContextConfig fakeLogin) {
        this.postRepository = postRepository;
        this.fakeLogin = fakeLogin;
    }

    @Override
    public Post toModel(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setContent(postDTO.getContent());
        post.setUser(postDTO.getUser());
        post.setUpvotesUserIds(postDTO.getUpvotesUserIds());
        return post;
    }

    @Override
    public PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setUser(post.getUser());
        postDTO.setUpvotesUserIds(post.getUpvotesUserIds());
        return postDTO;
    }

    @Override
    public Post toModel(PostSummaryDTO postSummaryDTO) {
        Post post = new Post();
        post.setId(postSummaryDTO.getId());
        post.setContent(postSummaryDTO.getContent());
        return post;
    }

    @Override
    public PostSummaryDTO toSummaryDTO(Post post) {
        int upvotes;
        PostSummaryDTO postSummaryDTO = new PostSummaryDTO();
        if (post.getId() == null || postRepository.getById(post.getId()).getUpvotesUserIds() == null) {
            upvotes = 0;
        } else {
            List<Long> upvotesList = postRepository.getById(post.getId()).getUpvotesUserIds();
            upvotes = postRepository.getById(post.getId()).getUpvotesUserIds().size();
            if (upvotesList.contains(fakeLogin.loggedUser().getId())) {
                postSummaryDTO.setUpvotedByUser(true);
            }
        }
        postSummaryDTO.setId(post.getId());
        postSummaryDTO.setContent(post.getContent());
        postSummaryDTO.setUpvotes(upvotes);
        postSummaryDTO.setUserId(post.getUser().getId());
        postSummaryDTO.setUsername(post.getUser().getUsername());
        return postSummaryDTO;
    }
}
