package ru.example.processing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.example.atm.Cash;
import ru.example.client.Account;

@Data
@Getter
@AllArgsConstructor
public class CustomerAccount<T extends Account>{
    private final String ID;
    private final String firstName;
    private final String lastName;
    private T account;
    @Setter
    private Cash balance;

 }

