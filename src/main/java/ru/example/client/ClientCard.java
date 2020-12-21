package ru.example.client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class ClientCard{
    private final String cardPAN;
    private final LocalDate cardExp;
    private String cardPin;

    public ClientCard(String cardPAN, LocalDate cardExp) throws ClientCardFormatException{
        if (cardPAN.matches("^[0-9]{16,18}$")){
            this.cardPAN = cardPAN;
            this.cardExp = cardExp;
        }
        else throw new ClientCardFormatException("Номер карты некорректный.");
     }

    public void setCardPin(String cardPin) throws ClientCardFormatException{
        if (cardPin.matches("^[0-9]{4}$")){
            this.cardPin = cardPin;
        }
        else throw new ClientCardFormatException("Пин код должен состоять из 4 цифр. Введенный пин некоррекный");
        }
}

