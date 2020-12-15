package ru.example.processing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.example.atm.Cash;
import ru.example.client.ClientCard;

@Data
@Getter
@AllArgsConstructor
public class ClientAccount {
    private final String ID;
    private final String firstName;
    private final String lastName;
    private ClientCard clientCard;

    @Setter
    private Cash balance;

 }

