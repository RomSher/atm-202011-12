package ru.example.client;

public class Client {

    private String clientID;
    private ClientCard clientCard; //связываем карту с клиентом



    public Client(String clientID, ClientCard clientCard) {
        this.clientID = clientID;
        this.clientCard = clientCard;
    }
}
