package ru.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    String clientID;
    ClientCard clientCard;
}


