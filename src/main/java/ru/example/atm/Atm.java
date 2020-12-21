package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.client.*;
import ru.example.processing.Exceptions.*;
import ru.example.processing.*;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Atm {
    private CardRider cardRider;
    private CashDispenser cashDispenser;
    private Display display;
    private KeyBoard keyBoard;

    public Atm startAtm() {
        CashDispenser cashDispenser1 = new CashDispenser(true, true, new CashRegister("100", Currency.RUR, 500), new CashRegister("1000", Currency.RUR, 500));
        CardRider cardrider1 = new CardRider(true, true);
        Display display1 = new Display(true);
        KeyBoard keyboard1 = new KeyBoard(true, true);
        Atm atm = new Atm(cardrider1, cashDispenser1, display1, keyboard1);
        System.out.println("ATM is ready.");
        System.out.println();
        return atm;
    }

    public void giveMoney() {
        try {
            Atm atm = startAtm();
            System.out.println("Вставьте карту:");
            ClientCard card1 = atm.getCardRider().readCard();
            System.out.println("Введите PIN: ");
            card1.setCardPin(atm.getKeyBoard().readPinCode());
            System.out.println(card1.getCardPin());
            System.out.println(card1.toString());
            Client client1 = new Client(card1);
            System.out.println("Введите сумму для снятия:");
            Cash sum = atm.getKeyBoard().readSumma();
            System.out.println(sum.toString());
            Transaction transaction = new Transaction("0000000001", client1, sum);
            ArrayList<ClientAccount> accounts = new TempOperations().createAccounts();

            ClientAccount clientAccount = accounts.get(new TempOperations().findClientByCard(transaction, accounts));
            System.out.println();
            System.out.println("Здравствуйте "+ clientAccount.getLastName()+" "+clientAccount.getFirstName());

            if (new TempOperations().checkCardBalance(transaction, clientAccount) == Status.SUCCESS) {
                System.out.println();
                System.out.println("Ваш первоначальный баланс: "+clientAccount.getBalance().toString());
                new TempOperations().decreaseBalance(transaction, clientAccount);
                System.out.println();
                System.out.println("Остаток наличных: "+clientAccount.getBalance().toString());
                System.out.println();
            }
        } catch (CardNotFoundException | ClientCardFormatException | ClientBalanceIsLowException e) {
            System.out.println(e);
        }
    }
}
