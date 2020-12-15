package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyBoard {
    private boolean inService;
    private boolean noBusy;

    public String readPinCode(){
        return "1234";
    }

    public Cash readSumma(){
           return new Cash(1000,Currency.RUR);
    }
}
