package com.d3lt4.bookstore.config.security.exceptions;

public class GenerateTokenException extends RuntimeException {
    private static final Long serialVersionID = 1L;

    public GenerateTokenException(String message) {
        super(message);
    }

    public GenerateTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
