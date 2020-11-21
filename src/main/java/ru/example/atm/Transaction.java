package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.example.client.Client;

@Data
@AllArgsConstructor
public class Transaction {
    String transactionID;
    Client client;
    Cash cash;
}
