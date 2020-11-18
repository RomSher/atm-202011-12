package ru.example.atm;

import ru.example.client.ClientCard;

public class CardRider {

    private boolean inService;
    private boolean noBusy;

    public ClientCard readCard(){
        ClientCard card1 = new ClientCard("1111111111111","112020","1234");
    return card1;
    }

    public CardRider(boolean inService, boolean noBusy) {
        this.inService = inService;
        this.noBusy = noBusy;
    }

}
