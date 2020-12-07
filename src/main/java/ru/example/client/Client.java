package ru.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Client {
    private String ID;
    private String firstName;
    private String lastName;
    private ClientCard clientCard;

    public Client(ClientCard clientCard) {
        this.ID = "0000000000";
        this.clientCard = clientCard;
    }
}


