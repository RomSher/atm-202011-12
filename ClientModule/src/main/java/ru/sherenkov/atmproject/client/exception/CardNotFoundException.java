package ru.sherenkov.atmproject.client.exception;

public class CardNotFoundException extends Exception{

    public CardNotFoundException() {
    }

    public CardNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public CardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardNotFoundException(Throwable cause) {
        super(cause);
    }

    public CardNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
