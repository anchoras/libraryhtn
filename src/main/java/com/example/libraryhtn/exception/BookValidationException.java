package com.example.libraryhtn.exception;

public class BookValidationException extends BookException {

    public BookValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookValidationException(String message) {
        super(message);
    }

}
