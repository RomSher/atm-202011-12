package ru.example.client;

public class ClientCard {
    private String cardPAN;
    private String cardExp;
    private String cardPin;


    public ClientCard(String cardPAN, String cardExp, String cardPin) {
        this.cardPAN = cardPAN;
        this.cardExp = cardExp;
        this.cardPin = cardPin;
    }
}
