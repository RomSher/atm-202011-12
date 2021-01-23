package ru.example;

import ru.example.atm.Atm;
import ru.example.client.*;
import ru.example.processing.CustomerAccount;
import ru.example.processing.TempOperations;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Atm atm = new Atm().startAtm();
        ArrayList<CustomerAccount> accounts = new TempOperations().createAccounts();
        Scanner s = new Scanner(System.in);
        String reader;
        do {
            System.out.println("1 - снять наличные, 2 - забрать карту.");
            reader = s.nextLine();
            switch (reader) {
                case "1":
                    atm.giveMoney(atm,accounts);
                    break;
            }
        }
        while (!reader.equals("2"));
    }
}
