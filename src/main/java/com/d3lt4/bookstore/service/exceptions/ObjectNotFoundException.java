package com.d3lt4.bookstore.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final Long serialVersionID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
