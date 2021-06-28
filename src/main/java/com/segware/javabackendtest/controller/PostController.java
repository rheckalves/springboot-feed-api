package com.segware.javabackendtest.controller;

import com.segware.javabackendtest.config.FakeLoginConfig;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.UpvoteDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.entity.User;
import com.segware.javabackendtest.exception.PostNotFoundException;
import com.segware.javabackendtest.exception.UserNotFoundException;
import com.segware.javabackendtest.service.PostService;
import com.segware.javabackendtest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController implements PostControllerDocs {

    private final PostService postService;
    private final FakeLoginConfig fakeLogin;

    public PostController(PostService postService, FakeLoginConfig fakeLogin) {
        this.postService = postService;
        this.fakeLogin = fakeLogin;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostSummaryDTO createPost(@RequestBody PostDTO post) {
        User user = fakeLogin.loggedUser();
        post.setUser(user);
        return postService.createPost(post);
    }

    @PostMapping("/up")
    public HttpStatus upvotePost(@RequestBody UpvoteDTO upvoteDTO) throws PostNotFoundException {
        Long postId = upvoteDTO.getPostId();
        return postService.upvotePost(postId);
    }

    @GetMapping
    public List<PostSummaryDTO> listPosts() {
        return postService.listAll();
    }
}
