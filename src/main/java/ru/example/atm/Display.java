package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Display {
    private boolean inService;

    public void showErrors(){
    }
    public void showOk(){
    }
}
