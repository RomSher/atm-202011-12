package ru.example.client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ClientCard{
    private final String cardPAN;
    private final LocalDate cardExp;
    private String cardPin;

    public ClientCard(String cardPAN, LocalDate cardExp) throws ClientCardFormatException{
        if (cardPAN.matches("^[0-9]{16,18}$")){
            this.cardPAN = cardPAN;
        }
        else throw new ClientCardFormatException("Номер карты некорректный.");
        this.cardExp = cardExp;
    }

    public void setCardPin(String cardPin) throws ClientCardFormatException{
        if (cardPin.matches("^[0-9]{4}$")){
            this.cardPin = cardPin;
        }
        else throw new ClientCardFormatException("Пин код должен состоять из 4 цифр. Введенный пин некоррекный");
        }

    @Override
    public String toString() {
        return "ClientCard{" +
                "cardPAN='" + cardPAN + '\'' +
                ", cardExp=" + cardExp +
                ", cardPin='" + cardPin + '\'' +
                '}';
    }
}

