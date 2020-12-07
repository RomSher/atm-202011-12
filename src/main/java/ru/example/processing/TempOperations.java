package ru.example.processing;

import ru.example.atm.Cash;
import ru.example.atm.Currency;
import ru.example.atm.Status;
import ru.example.atm.Transaction;
import ru.example.processing.Exceptions.CardNotFoundException;
import ru.example.processing.Exceptions.ClientBalanceIsLowException;
import java.util.ArrayList;

public class TempOperations {

    public int findClientByCard(Transaction transaction, ArrayList<ClientAccount> accounts) throws CardNotFoundException {
        //проверить валидность карты
        for (ClientAccount account : accounts) {
            if (transaction.getClient().getClientCard().getCardPAN().equals(account.getClientCard().getCardPAN())
            && transaction.getClient().getClientCard().getCardPin().equals(account.getClientCard().getCardPin())
            && transaction.getClient().getClientCard().getCardExp().equals(account.getClientCard().getCardExp())) {
                return new ArrayList<>(accounts).indexOf(account);
            }

        }
        throw new CardNotFoundException("Карта не найдена или пин некорректный");
    }


    public Status checkCardBalance(Transaction transaction, ClientAccount account) throws ClientBalanceIsLowException {
        //проверить баланс карты
        if (transaction.getCash().getSum() < account.getBalance().getSum() && transaction.getCash().getVal().equals(account.getBalance().getVal())) {
            return Status.SUCCESS;
        }
        throw new ClientBalanceIsLowException("Баланс счета недостаточен для снятия указанной суммы");
    }

    public Status decreaseBalance (Transaction transaction, ClientAccount account){
        int oldBalance = account.getBalance().getSum();
        int newBalance = oldBalance - transaction.getCash().getSum();
        Currency val = account.getBalance().getVal();
        account.setBalance(new Cash(newBalance,val));
        return Status.SUCCESS;
    }
}
