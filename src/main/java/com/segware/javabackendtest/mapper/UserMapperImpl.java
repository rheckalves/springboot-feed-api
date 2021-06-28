package com.segware.javabackendtest.mapper;

import com.segware.javabackendtest.dto.request.UserDTO;
import com.segware.javabackendtest.entity.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public User toModel(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}
