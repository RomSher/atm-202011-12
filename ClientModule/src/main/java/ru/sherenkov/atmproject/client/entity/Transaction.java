package ru.sherenkov.atmproject.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private String ID;
    private Client client;
    private Cash cash;
}
