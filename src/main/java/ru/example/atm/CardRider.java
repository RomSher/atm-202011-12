package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import ru.example.client.ClientCard;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CardRider {
    private boolean inService;
    private boolean noBusy;

    @SneakyThrows
    public ClientCard readCard() {
        return new ClientCard("1111222233334444",LocalDate.of(2020, 12, 31));
    }
}