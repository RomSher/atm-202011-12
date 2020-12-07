package ru.example.processing.Exceptions;

public class CardNotFoundException extends Exception{

    public CardNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
