package com.segware.javabackendtest.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostException {
    private Integer status;
    private String title;
    private String message;
}
