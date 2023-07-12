package com.d3lt4.bookstore.service.exceptions;

public class CategoriaExistenteException extends RuntimeException {
    private static final Long serialVersionID = 1L;

    public CategoriaExistenteException(String message) {
        super(message);
    }

    public CategoriaExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
