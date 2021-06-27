package com.segware.javabackendtest.config;

import com.segware.javabackendtest.entity.User;
import com.segware.javabackendtest.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeLoginConfig {
    @Bean
    public User loggedUser() {
        return UserService.createRandomUser();
    }
}
