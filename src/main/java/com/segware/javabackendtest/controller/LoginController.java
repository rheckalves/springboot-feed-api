package com.segware.javabackendtest.controller;

import com.segware.javabackendtest.config.FakeSecurityContextConfig;
import com.segware.javabackendtest.config.MapperConfig;
import com.segware.javabackendtest.dto.request.UserDTO;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    private final FakeSecurityContextConfig fakeLogin;
    private final MapperConfig mapper;

    public LoginController(FakeSecurityContextConfig fakeLogin, MapperConfig mapper) {
        this.fakeLogin = fakeLogin;
        this.mapper = mapper;
    }

    @GetMapping
    public UserDTO login() {
        return mapper.userMapper().toDTO(fakeLogin.loggedUser());
    }
}
