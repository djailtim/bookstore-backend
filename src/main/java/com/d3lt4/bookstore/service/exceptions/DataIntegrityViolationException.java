package com.d3lt4.bookstore.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
    private static final Long serialVersionID = 1L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
