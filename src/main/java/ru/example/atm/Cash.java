package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cash {
    private int sum;
    private String val;
}
