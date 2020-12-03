package ru.example.client;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ClientCard {
    private String cardPAN;
    private LocalDate cardExp;
    private String cardPin;

    public ClientCard(String cardPAN, LocalDate cardExp) {
        if (cardPAN.matches("^[0-9]{16}$")){
            this.cardPAN = cardPAN;
        }
        this.cardExp = cardExp;
    }
}

