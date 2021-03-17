package ru.sherenkov.atmproject.client.entity;

import lombok.Data;

@Data
public class Client <T extends Account>{
    private int id;
    private String firstName;
    private String lastName;
    private T account;

    public Client(Account account) {
        this.account = (T) account;
    }
}


