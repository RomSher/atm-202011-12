package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardRider {
    boolean inService;
    boolean noBusy;

    public String readCardPAN(){
        return "1111222233334444";
    }
    public String readCardExp(){
        return "112020";
    }
}
