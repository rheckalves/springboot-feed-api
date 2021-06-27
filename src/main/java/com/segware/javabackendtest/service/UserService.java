package com.segware.javabackendtest.service;

import com.segware.javabackendtest.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    public static User createRandomUser() {
        User userOne = new User(1L, "gumercindo22");
        User userTwo = new User(2L, "genaceia77");
        User userThree = new User(3L, "astolfo44");
        User userFour = new User(4L, "anastacio33");
        User userFive = new User(5L, "genoveva88");
        List<User> randomUsers = new ArrayList<>(){{
            add(userOne);
            add(userTwo);
            add(userThree);
            add(userFour);
            add(userFive);
        }};

        Random rand = new Random();
        return randomUsers.get(rand.nextInt(randomUsers.size()));
    }
}
