package ru.sherenkov.atmproject.server.processing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Value
public class ClientDTO {
    private final int clientId;
    private final String firstName;
    private final String lastName;
    private final List<AccountDTO> accountDTO;
}
