package ru.sherenkov.atmproject.server.processing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class AccountDTO {
    private final String cardPan;
    private final String cardPin;
    private final LocalDate cardExp;
    private final BigDecimal balance;
}
