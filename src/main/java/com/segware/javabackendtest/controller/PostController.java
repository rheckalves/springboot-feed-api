package com.segware.javabackendtest.controller;

import com.segware.javabackendtest.config.FakeLoginConfig;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.entity.User;
import com.segware.javabackendtest.service.PostService;
import com.segware.javabackendtest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;
    private final FakeLoginConfig fakeLogin;

    public PostController(PostService postService, FakeLoginConfig fakeLogin) {
        this.postService = postService;
        this.fakeLogin = fakeLogin;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO createPost(@RequestBody PostDTO post) {
        User user = fakeLogin.loggedUser();
        post.setUserId(user.getId());
        post.setUsername(user.getUsername());
        return postService.createPost(post);
    }

    @GetMapping
    public List<PostDTO> listPosts() {
        return postService.listAll();
    }
}
