package ru.example.client;

import lombok.Data;

@Data
public class Client <T extends Account>{
    private String firstName;
    private String lastName;
    private T account;

    public Client(Account account) {
        this.account = (T) account;
    }
}


