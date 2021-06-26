package com.segware.javabackendtest.mapper;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.model.Post;

public interface PostMapper {

    Post toModel(PostDTO postDTO);

    PostDTO toDTO(Post post);
}
