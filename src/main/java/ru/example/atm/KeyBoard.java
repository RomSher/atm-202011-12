package ru.example.atm;

public class KeyBoard {

    private boolean inService;
    private boolean noBusy;

    public String readPinCode(){
        return "1234";
    }
    public String readSumma(){
        return "1000";
    }

    public KeyBoard(boolean inService, boolean noBusy) {
        this.inService = inService;
        this.noBusy = noBusy;
    }
}
