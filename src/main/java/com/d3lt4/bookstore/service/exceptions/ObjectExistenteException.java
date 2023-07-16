package com.d3lt4.bookstore.service.exceptions;

public class ObjectExistenteException extends RuntimeException {
    private static final Long serialVersionID = 1L;

    public ObjectExistenteException(String message) {
        super(message);
    }

    public ObjectExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
