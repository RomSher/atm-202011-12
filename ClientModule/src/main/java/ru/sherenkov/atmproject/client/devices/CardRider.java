package ru.sherenkov.atmproject.client.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sherenkov.atmproject.client.entity.*;
import ru.sherenkov.atmproject.client.exception.ClientCardFormatException;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CardRider {
    private boolean inService;
    private boolean noBusy;

    public Account readCard() throws ClientCardFormatException {
        return new Account("1111222233334444",LocalDate.of(2021, 12,31));
    }
}