package ru.example.processing.Exceptions;

public class ClientBalanceIsLowException extends Exception {

    public ClientBalanceIsLowException(String errorMessage) {
        super(errorMessage);
    }

}
