package ru.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientCard {
    String cardPAN;
    String cardExp;
    String cardPin;
}

