package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Display {
    boolean inService;

    public void showErrors(){
    }
    public void showOk(){
    }
}
