package ru.example;

import ru.example.atm.Atm;
import ru.example.client.*;
import ru.example.processing.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws ClientCardFormatException {
        Scanner s = new Scanner(System.in);
        String reader;
        do {
            System.out.println("1 - снять наличные, 2 - забрать карту.");
            reader = s.nextLine();
            switch (reader) {
                case "1":
                    new Atm().giveMoney();
                    break;
            }
        }
        while (!reader.equals("2"));
    }
}
