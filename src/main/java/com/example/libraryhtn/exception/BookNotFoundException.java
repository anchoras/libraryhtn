package com.example.libraryhtn.exception;

public class BookNotFoundException extends BookException {

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(String message) {
        super(message);
    }

}
