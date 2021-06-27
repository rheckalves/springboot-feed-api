package com.segware.javabackendtest.mapper;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.entity.Post;

public interface PostMapper {

    Post toModel(PostDTO postDTO);

    PostDTO toDTO(Post post);

    Post toModel(PostSummaryDTO postSummaryDTO);

    PostSummaryDTO toSummaryDTO(Post post);
}
