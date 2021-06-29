package com.segware.javabackendtest.service;
import com.segware.javabackendtest.entity.User;
import com.segware.javabackendtest.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    protected Boolean verifyIfUserExists(Long userId) {
        return userRepository.existsById(userId);
    }


    public User loginUser() {
        User user = createRandomUser();
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            userRepository.save(user);
            return user;
        }
        return userRepository.findByUsername(user.getUsername()).get();
    }

    public static User createRandomUser() {
        User userOne = new User("gumercindo22");
        User userTwo = new User("genaceia77");
        User userThree = new User("astolfo44");
        User userFour = new User("anastacio33");
        User userFive = new User("genoveva88");
        User userSix = new User("lorenilson44");
        User userSeven = new User("nicelia33");
        List<User> randomUsers = new ArrayList<>(){{
            add(userOne);
            add(userTwo);
            add(userThree);
            add(userFour);
            add(userFive);
            add(userSix);
            add(userSeven);
        }};

        Random rand = new Random();
        return randomUsers.get(rand.nextInt(randomUsers.size()));
    }
}
