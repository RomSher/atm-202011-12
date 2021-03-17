package ru.sherenkov.atmproject.common.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ResponseClients {
    private List clients;

}
