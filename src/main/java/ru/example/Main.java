package ru.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.atm.Atm;
import ru.example.processing.CustomerAccount;
import ru.example.processing.TempOperations;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        Atm atm = a.getBean(Atm.class);
        ArrayList<CustomerAccount> base = new TempOperations().createBase();
        Scanner s = new Scanner(System.in);
        String reader;
        do {
            System.out.println("1 - снять наличные, 2 - забрать карту.");
            reader = s.nextLine();
            switch (reader) {
                case "1":
                    atm.giveMoney(atm, base);
                    break;
            }
        }
        while (!reader.equals("2"));
    }
}
