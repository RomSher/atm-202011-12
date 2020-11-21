package ru.example;

import ru.example.client.*;
import ru.example.atm.*;

public class Main{

    public static void main(String[] args) {
        //Start ATM
        CashDispenser cashier1 = new CashDispenser(true, true, new CashRegister("100",new Cash(1000000,"RUR")));
        CardRider cardrider1 = new CardRider(true, true);
        Display display1 = new Display(true);
        KeyBoard keyboard1 = new KeyBoard(true, true);

        //setClient
        Client client1 = new Client("0001", new ClientCard(cardrider1.readCardPAN(), cardrider1.readCardExp(), keyboard1.readPinCode()));
        //setTransaction
        Transaction transaction1 = new Transaction("0001", client1, keyboard1.readSumma());

        System.out.println(transaction1.toString());
        System.out.println(cashier1.toString());
    }
}
