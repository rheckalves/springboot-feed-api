package com.segware.javabackendtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

   // public UserNotFoundException(String userName) {
   //     super(String.format("User with username %s not found in the system.", userName));
   // }

    public UserNotFoundException(Long userId) {
        super(String.format("User with Id %s not found in the system.", userId));
    }
}
