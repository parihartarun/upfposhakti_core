package com.upfpo.app.user.exception;

public class InvalidFileTypeExcepton extends RuntimeException {

    public InvalidFileTypeExcepton(String message) {
        super(message);
    }

    public InvalidFileTypeExcepton(String message, Throwable cause) {
        super(message, cause);
    }
}
