package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CashRegister {
    private String nominal;
    private Cash sum;
}
