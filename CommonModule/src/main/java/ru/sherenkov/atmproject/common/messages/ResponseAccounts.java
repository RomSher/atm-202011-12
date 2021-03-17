package ru.sherenkov.atmproject.common.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ResponseAccounts {
    private String firstName;
    private String lastName;
    private List accountDTO;

}
