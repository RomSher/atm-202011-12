package ru.example.atm;

import ru.example.client.ClientCard;

public class CardRider {

    private boolean inService;
    private boolean noBusy;

    public String readCardPAN(){
        return "111111111111";
    }
    public String readCardExp(){
        return "110202";
    }

    public CardRider(boolean inService, boolean noBusy) {
        this.inService = inService;
        this.noBusy = noBusy;
    }

}
