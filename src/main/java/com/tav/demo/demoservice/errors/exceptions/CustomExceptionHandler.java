package com.tav.demo.demoservice.errors.exceptions;

import com.tav.demo.demoservice.errors.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyExistsException.class)
    public ErrorDetails alreadyExistsExceptionHandler(final AlreadyExistsException e) {
        return new ErrorDetails(e.getMessage());
    }
}
