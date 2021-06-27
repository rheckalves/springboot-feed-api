package com.segware.javabackendtest.controller;

import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;

@Api("Manages Posts")
public interface PostControllerDocs {

    @ApiOperation(value = "Post creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success post creation"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    PostSummaryDTO createPost(PostDTO postDTO);

    @ApiOperation(value = "Returns a list of all posts registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all posts registered in the system"),
    })
    List<PostSummaryDTO> listPosts();

}
