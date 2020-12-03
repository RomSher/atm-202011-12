package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardRider {
    private boolean inService;
    private boolean noBusy;

    public String readCardPAN(){
        return "1111222233334444";
    }
    public String readCardExp(){
        return "112020";
    }
}
