package ru.sherenkov.atmproject.client.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import ru.sherenkov.atmproject.client.entity.*;

@Data
@AllArgsConstructor
public class KeyBoard {
    private boolean inService;
    private boolean noBusy;

    public String readPinCode(){
        return "1234";
    }

    public Cash readSumma(){
           return new Cash(new BigDecimal(40000),Currency.RUR);
    }
}
