package ru.example;

import ru.example.client.*;
import ru.example.atm.*;

public class Main{

    public static void main(String[] args) {

        CashDispenser cashier1 = new CashDispenser(true, true, 1000000);
        CardRider cardrider1 = new CardRider(true, true);
        Display display1 = new Display(true);
        KeyBoard keyboard1 = new KeyBoard(true, true);

        Client client1 = new Client("0001", cardrider1.readCard());

    }
}
