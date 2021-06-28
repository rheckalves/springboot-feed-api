package com.segware.javabackendtest.controller;

import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.UpvoteDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.exception.PostNotFoundException;
import com.segware.javabackendtest.exception.UserNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;

import java.util.List;

@Api("Manages Posts")
public interface PostControllerDocs {

    @ApiOperation(value = "Post creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success post creation"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    PostSummaryDTO createPost(PostDTO postDTO) throws UserNotFoundException;

    @ApiOperation(value = "Upvote Post")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success post upvoted"),
            @ApiResponse(code = 404, message = "Post not found")
    })
    HttpStatus upvotePost(UpvoteDTO upvoteDTO) throws PostNotFoundException;

    @ApiOperation(value = "Returns a list of all posts registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all posts registered in the system"),
    })
    List<PostSummaryDTO> listPosts();

}
