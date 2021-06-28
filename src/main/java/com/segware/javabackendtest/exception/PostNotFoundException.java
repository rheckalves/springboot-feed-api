package com.segware.javabackendtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends Exception {

    public PostNotFoundException(Long id) {
        super(String.format("Post with id %s not found in the system.", id));
    }

}