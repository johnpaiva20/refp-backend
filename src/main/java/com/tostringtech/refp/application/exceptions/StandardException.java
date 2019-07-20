package com.tostringtech.refp.application.exceptions;

public class StandardException extends RuntimeException {

    public StandardException(String message) {
        super(message);
    }

    public StandardException(String message, Throwable cause) {
        super(message, cause);
    }
}
