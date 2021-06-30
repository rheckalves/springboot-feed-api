package com.segware.javabackendtest.utils;

import com.segware.javabackendtest.entity.Post;
import com.segware.javabackendtest.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {
    private static final Post FAKE_POST = PostUtils.createFakeEntity();
    private static final Long USER_ID = 1L;
    private static final String USERNAME = "lorivadomello";
    private static final List<Post> POSTS = new ArrayList<>();

    public static User createFakeUser() {
        return User.builder()
                .id(USER_ID)
                .username(USERNAME)
                .posts(POSTS)
                .build();
    }
}
