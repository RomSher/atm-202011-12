package ru.example;

import ru.example.client.*;
import ru.example.atm.*;

public class Main{

    public static void main(String[] args) {
        //Start ATM
        CashDispenser cashier1 = new CashDispenser(true, true, 1000000);
        CardRider cardrider1 = new CardRider(true, true);
        Display display1 = new Display(true);
        KeyBoard keyboard1 = new KeyBoard(true, true);

        //readCard, createClient
        ClientCard card1= new ClientCard(cardrider1.readCardPAN(), cardrider1.readCardExp(),keyboard1.readPinCode());
        Client client1 = new Client("0001", card1);

    }
}
