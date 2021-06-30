package com.segware.javabackendtest.handler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PostExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        PostException postException = new PostException();
        postException.setStatus(status.value());
        postException.setTitle("Validation Error");
        postException.setMessage(ex.getMessage());
        return handleExceptionInternal(ex, postException, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        PostException postException = new PostException();
        postException.setStatus(status.value());
        postException.setTitle("Internal Server Error");
        postException.setTitle(ex.getMessage());
        return new ResponseEntity(postException, headers, status);
    }
}
