package com.segware.javabackendtest.service;

import com.segware.javabackendtest.config.MapperConfig;
import com.segware.javabackendtest.dto.request.UserDTO;
import com.segware.javabackendtest.entity.User;
import com.segware.javabackendtest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    public UserService(UserRepository userRepository, MapperConfig mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    private final UserRepository userRepository;
    private final MapperConfig mapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = mapper.userMapper().toModel(userDTO);
        User savedUser = userRepository.save(user);
        return mapper.userMapper().toDTO(savedUser);
    }

    public User loginUser() {
        User user = createRandomUser();
        return userRepository.findByUsername(user.getUsername()).orElse(userRepository.save(user));
    }

    public static User createRandomUser() {
        User userOne = new User("gumercindo22");
        User userTwo = new User("genaceia77");
        User userThree = new User("astolfo44");
        User userFour = new User("anastacio33");
        User userFive = new User("genoveva88");
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
