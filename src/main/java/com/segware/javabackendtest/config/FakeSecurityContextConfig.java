package com.segware.javabackendtest.config;

import com.segware.javabackendtest.entity.User;
import com.segware.javabackendtest.repository.UserRepository;
import com.segware.javabackendtest.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeSecurityContextConfig {

    private final UserService userService;

    public FakeSecurityContextConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public User loggedUser() {
       return userService.loginUser();
    }
}
