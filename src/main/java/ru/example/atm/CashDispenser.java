package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CashDispenser {
    boolean inService;
    boolean noBusy;
    CashRegister cashInATM;
}