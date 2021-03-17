package ru.sherenkov.atmproject.client.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sherenkov.atmproject.client.entity.*;

@Data
@AllArgsConstructor
public class CashRegister {
    private String nominal;
    private Currency currency;
    private int banknotes;
}
