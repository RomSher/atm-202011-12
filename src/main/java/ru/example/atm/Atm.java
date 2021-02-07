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

    public void giveMoney(Atm atm,ArrayList<CustomerAccount> accounts) {
        try {
            Account card1 = atm.getCardRider().readCard();
            card1.setCardPin(atm.getKeyBoard().readPinCode());
            log.info("Карта: "+card1.toString());
            Client client = new Client(card1);
            Cash sum = atm.getKeyBoard().readSumma();
            log.info("Запрошено: "+sum.toString());
            Transaction transaction = new Transaction("1", client, sum);
            new TempOperations().checkAccExp(transaction);
            new TempOperations().checkDoubleRequest(transaction,atm);

            CustomerAccount customerAccount = accounts.get(new TempOperations().findClientByCard(transaction, accounts));
            log.info("Клиент найден: "+ customerAccount.getLastName()+" "+ customerAccount.getFirstName());
            log.info("Первоначальный баланс: "+ customerAccount.getBalance().toString());

            Status result = new TempOperations().decreaseBalance(transaction, customerAccount);
            log.info(result + "Остаток после операции: "+ customerAccount.getBalance().toString());

        } catch (CardNotFoundException | ClientCardFormatException | ClientBalanceException e) {
            log.info(Status.ERROR+" "+e.getMessage());
        }
    }
}
