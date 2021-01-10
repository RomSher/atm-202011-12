package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.example.client.Account;
import ru.example.client.ClientCardFormatException;

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