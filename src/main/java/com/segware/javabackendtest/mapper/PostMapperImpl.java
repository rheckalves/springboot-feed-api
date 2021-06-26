package com.segware.javabackendtest.mapper;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.model.Post;

public class PostMapperImpl implements PostMapper {

    @Override
    public Post toModel(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setUpvotes(postDTO.getUpvotes());
        return post;
    }

    @Override
    public PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setUpvotes(post.getUpvotes());
        return postDTO;
    }
}
