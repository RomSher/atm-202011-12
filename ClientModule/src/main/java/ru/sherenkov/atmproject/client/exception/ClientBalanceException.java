package ru.sherenkov.atmproject.client.exception;

public class ClientBalanceException extends Exception {
    public ClientBalanceException() {
    }

    public ClientBalanceException(String errorMessage) {
        super(errorMessage);
    }

    public ClientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientBalanceException(Throwable cause) {
        super(cause);
    }

    public ClientBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
