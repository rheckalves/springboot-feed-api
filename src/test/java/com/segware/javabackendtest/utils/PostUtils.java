package com.segware.javabackendtest.utils;

import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.dto.request.response.PostSummaryDTO;
import com.segware.javabackendtest.entity.Post;
import com.segware.javabackendtest.entity.User;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

import static com.segware.javabackendtest.utils.UserUtils.createFakeUser;

public class PostUtils {

    private static final Long POST_ID = 1L;
    private static final String CONTENT = "Lorem Ipsum";
    private static final User USER = createFakeUser();
    private static final List<Long> UPVOTES_USER_IDS = new ArrayList<>() {{ add(1L); add(2L); add(3L); }};

    private static Post post = Post.builder().id(5L).user(createFakeUser()).content("xablau").upvotesUserIds(new ArrayList<>() {{ add(1L); add(2L); add(3L); }}).build();
    private static User user = User.builder().id(2L).username("genoveva11").posts(new ArrayList<>(){{ add(post); }}).build();


    public static PostDTO createFakeDTO() {
        return PostDTO.builder()
                .id(POST_ID)
                .content(CONTENT)
                .user(user)
                .upvotesUserIds(new ArrayList<>(){{add(2L);}})
                .build();
    }

    public static PostSummaryDTO createFakeSummaryDTO() {
        return PostSummaryDTO.builder()
                .id(POST_ID)
                .content(CONTENT)
                .userId(2L)
                .upvotedByUser(false)
                .upvotes(0)
                .username("genoveva11")
                .build();
    }

    public static Post createFakeEntity() {
        return Post.builder()
                .id(POST_ID)
                .content(CONTENT)
                .user(user)
                .upvotesUserIds(new ArrayList<>(){{add(2L);}})
                .build();
    }

}