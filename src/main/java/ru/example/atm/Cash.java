package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Cash {
    private BigDecimal amount;
    private Currency val;
}
