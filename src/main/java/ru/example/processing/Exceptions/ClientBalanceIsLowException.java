package ru.example.processing.Exceptions;

public class ClientBalanceIsLowException extends Exception {
    public ClientBalanceIsLowException() {
    }

    public ClientBalanceIsLowException(String errorMessage) {
        super(errorMessage);
    }

    public ClientBalanceIsLowException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientBalanceIsLowException(Throwable cause) {
        super(cause);
    }

    public ClientBalanceIsLowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
