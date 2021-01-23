package ru.example.client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class Account {
    @NotNull(message = "Card number cannot be null")
    private String cardPAN;
    @NotNull(message = "Data expiration cannot be null")
    private LocalDate cardExp;
    @NotNull(message = "Pin cannot be null")
    @Size(min = 4,max = 4)
    private String cardPin;

    public Account(String cardPAN, LocalDate cardExp){
            this.cardPAN = cardPAN;
            this.cardExp = cardExp;
        }

    public void setCardPin(String cardPin){
            this.cardPin = cardPin;
        }
}

