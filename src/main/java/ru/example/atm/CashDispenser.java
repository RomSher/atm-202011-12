package ru.example.atm;

public class CashDispenser {

    private boolean inService;
    private boolean noBusy;
    private int cashInsert;

    public CashDispenser(boolean inService, boolean noBusy, int cashInto) {
        this.inService = inService;
        this.noBusy = noBusy;
        this.cashInsert = cashInto;
    }

}