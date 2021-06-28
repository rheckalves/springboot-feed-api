package com.segware.javabackendtest.mapper;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.entity.Post;

public class PostMapperImpl implements PostMapper {

    @Override
    public Post toModel(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setContent(postDTO.getContent());
        post.setUpvotes(postDTO.getUpvotes());
        post.setUser(postDTO.getUser());
        return post;
    }

    @Override
    public PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setUpvotes(post.getUpvotes());
        postDTO.setUser(post.getUser());
        return postDTO;
    }

    @Override
    public Post toModel(PostSummaryDTO postSummaryDTO) {
        Post post = new Post();
        post.setId(postSummaryDTO.getId());
        post.setContent(postSummaryDTO.getContent());
        post.setUpvotes(postSummaryDTO.getUpvotes());
        return post;
    }

    @Override
    public PostSummaryDTO toSummaryDTO(Post post) {
        PostSummaryDTO postSummaryDTO = new PostSummaryDTO();
        postSummaryDTO.setId(post.getId());
        postSummaryDTO.setContent(post.getContent());
        postSummaryDTO.setUpvotes(post.getUpvotes());
        postSummaryDTO.setUserId(post.getUser().getId());
        postSummaryDTO.setUsername(post.getUser().getUsername());
        return postSummaryDTO;
    }
}
