package ru.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Client {
    private String firstName;
    private String lastName;
    private ClientCard clientCard;

    public Client(ClientCard clientCard) {
        this.clientCard = clientCard;
    }
}


