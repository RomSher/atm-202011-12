package ru.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example.atm.*;
import java.util.HashSet;

@Configuration
public class ContextConfiguration {

    @Bean
    public Atm atm() {
        CashDispenser cashDispenser1 = new CashDispenser(true, true, new CashRegister("100", Currency.RUR, 500), new CashRegister("1000", Currency.RUR, 500));
        CardRider cardrider1 = new CardRider(true, true);
        KeyBoard keyboard1 = new KeyBoard(true, true);
        return new Atm(cardrider1, cashDispenser1, keyboard1, new HashSet<>());
    }
}