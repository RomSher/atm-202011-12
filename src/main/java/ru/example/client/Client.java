package ru.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Client {
    private String clientID;
    private String firstName; //будет ответ из бэкэнда с ФИО
    private String lastName;
    private ClientCard clientCard;

    public Client(String clientID, ClientCard clientCard) {
        this.clientID = clientID;
        this.clientCard = clientCard;
    }
}


