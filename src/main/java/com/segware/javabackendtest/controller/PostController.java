package com.segware.javabackendtest.controller;

import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO createPost(@RequestBody PostDTO post) {
        return postService.createPost(post);
    }

    @GetMapping
    public List<PostDTO> listPosts() {
        return postService.listAll();
    }
}
