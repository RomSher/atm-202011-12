package ru.example;

import ru.example.client.*;
import ru.example.atm.*;

import java.io.IOException;

public class Main{

    public static void main(String[] args) {
        //Start ATM
        CashDispenser cashier1 = new CashDispenser(true, true, new CashRegister("100",new Cash(100000,"RUR")),new CashRegister("1000",new Cash(1000000,"RUR")));
        CardRider cardrider1 = new CardRider(true, true);
        Display display1 = new Display(true);
        KeyBoard keyboard1 = new KeyBoard(true, true);

        //setClient
        System.out.println("ATM is ready.");
        System.out.println();
        System.out.println("Вставьте карту:");
        ClientCard card1 = new ClientCard(cardrider1.readCardPAN(), cardrider1.readCardExp());
        System.out.println(card1.toString());
        System.out.println("Введите PIN: ");
        card1.setCardPin(keyboard1.readPinCode());
        System.out.println(card1.getCardPin());
        Client client1 = new Client("0001", card1);
        System.out.println("Введите сумму для снятия:");
        //setTransaction
        Transaction transaction1 = new Transaction("000001", client1, keyboard1.readSumma());
        System.out.println(transaction1.getCash());
        System.out.println();

        System.out.println(transaction1.toString());
    }
}
