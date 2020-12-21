package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.example.client.ClientCard;
import ru.example.client.ClientCardFormatException;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CardRider {
    private boolean inService;
    private boolean noBusy;

    public ClientCard readCard() throws ClientCardFormatException {
        return new ClientCard("1111222233334444",LocalDate.of(2020, 12,31));
    }
}