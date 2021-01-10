package ru.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.example.client.*;
import ru.example.processing.Exceptions.*;
import ru.example.processing.*;
import java.util.ArrayList;
import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
public class Atm {
    private CardRider cardRider;
    private CashDispenser cashDispenser;
    private KeyBoard keyBoard;
    public HashSet<Account> doubleRequest;

    public Atm startAtm() {
        CashDispenser cashDispenser1 = new CashDispenser(true, true, new CashRegister("100", Currency.RUR, 500), new CashRegister("1000", Currency.RUR, 500));
        CardRider cardrider1 = new CardRider(true, true);
        KeyBoard keyboard1 = new KeyBoard(true, true);
        Atm atm = new Atm(cardrider1, cashDispenser1, keyboard1, new HashSet<>());
        ArrayList<CustomerAccount> accounts = new TempOperations().createAccounts();
        log.info("ATM is ready.");
        return atm;
    }

    public void giveMoney(Atm atm,ArrayList<CustomerAccount> accounts) {
        try {
            Account card1 = atm.getCardRider().readCard();
            card1.setCardPin(atm.getKeyBoard().readPinCode());
            log.info("Карта: "+card1.toString());
            Client client1 = new Client(card1);
            Cash sum = atm.getKeyBoard().readSumma();
            log.info("Запрошено: "+sum.toString());
            Transaction transaction = new Transaction("1", client1, sum);
            new TempOperations().checkAccExp(transaction);
            new TempOperations().checkDoubleRequest(transaction,atm);

            CustomerAccount customerAccount = accounts.get(new TempOperations().findClientByCard(transaction, accounts));
            log.info("Клиент найден: "+ customerAccount.getLastName()+" "+ customerAccount.getFirstName());
            log.info("Первоначальный баланс: "+ customerAccount.getBalance().toString());

            Status result = new TempOperations().decreaseBalance(transaction, customerAccount);
            log.info(result + " Остаток после операции: "+ customerAccount.getBalance().toString());

        } catch (CardNotFoundException | ClientCardFormatException | ClientBalanceException e) {
            log.info(Status.ERROR+" "+e.getMessage());
        }
    }
}
