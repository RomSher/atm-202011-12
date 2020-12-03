package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.example.client.Client;

@Data
@AllArgsConstructor
public class Transaction {
    private String ID;
    private Client client;
    private Cash cash;
}
