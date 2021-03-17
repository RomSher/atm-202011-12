package ru.sherenkov.atmproject.client.exception;

public class ClientCardFormatException extends Exception {

    public ClientCardFormatException() {
    }

    public ClientCardFormatException(String errorMessage) {
        super(errorMessage);
    }

    public ClientCardFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientCardFormatException(Throwable cause) {
        super(cause);
    }

    public ClientCardFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}