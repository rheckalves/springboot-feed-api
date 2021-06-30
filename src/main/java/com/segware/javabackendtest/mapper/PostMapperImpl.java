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
        return Post.builder()
                .id(postDTO.getId())
                .content(postDTO.getContent())
                .user(postDTO.getUser())
                .upvotesUserIds(postDTO.getUpvotesUserIds())
                .build();
    }

    @Override
    public PostDTO toDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .content(post.getContent())
                .user(post.getUser())
                .upvotesUserIds(post.getUpvotesUserIds())
                .build();
    }

    @Override
    public Post toModel(PostSummaryDTO postSummaryDTO) {
        return Post.builder()
                .id(postSummaryDTO.getId())
                .content(postSummaryDTO.getContent())
                .build();
    }

    @Override
    public PostSummaryDTO toSummaryDTO(Post post) {
        int upvotes;
        boolean upvotedByUser = false;
        if (post.getId() == null || postRepository.getById(post.getId()).getUpvotesUserIds() == null) {
            upvotes = 0;
        } else {
            List<Long> upvotesList = postRepository.getById(post.getId()).getUpvotesUserIds();
            upvotes = postRepository.getById(post.getId()).getUpvotesUserIds().size();
            if (upvotesList.contains(fakeLogin.loggedUser().getId())) {
                upvotedByUser = true;
            }
        }
        return PostSummaryDTO.builder()
                .id(post.getId())
                .content(post.getContent())
                .upvotes(upvotes)
                .userId(post.getUser().getId())
                .username(post.getUser().getUsername())
                .upvotedByUser(upvotedByUser)
                .build();
    }
}
