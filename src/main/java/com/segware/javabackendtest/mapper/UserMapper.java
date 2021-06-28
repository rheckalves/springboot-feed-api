package com.segware.javabackendtest.mapper;

import com.segware.javabackendtest.dto.request.UserDTO;
import com.segware.javabackendtest.entity.Post;
import com.segware.javabackendtest.entity.User;

public interface UserMapper {
    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);
}
