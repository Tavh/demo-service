package com.tav.demo.demoservice.errors.exceptions;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(final long id) {
        super("Couldn't find user with id: " + id);
    }
}
