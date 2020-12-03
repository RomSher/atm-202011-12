package ru.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ClientCard {
    private String cardPAN;
    private String cardExp;
    private String cardPin;

    public ClientCard(String cardPAN, String cardExp) {
        this.cardPAN = cardPAN;
        this.cardExp = cardExp;
    }
}

