package ru.sherenkov.atmproject.client.devices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CashDispenser {
    private boolean inService;
    private boolean noBusy;
    private CashRegister cashRegister1;
    private CashRegister cashRegister2;
}