package ru.example.processing;

import ru.example.atm.Cash;
import ru.example.atm.Currency;
import ru.example.atm.Status;
import ru.example.atm.Transaction;
import ru.example.client.ClientCard;
import ru.example.processing.Exceptions.CardNotFoundException;
import ru.example.processing.Exceptions.ClientBalanceIsLowException;

import java.time.LocalDate;
import java.util.ArrayList;

public class TempOperations {

    public ArrayList<ClientAccount> createAccounts(){
        ArrayList<ClientAccount> clientAccounts = new ArrayList<>();
        clientAccounts.add(new ClientAccount("0000000001","Ivan","Ivanov",new ClientCard("1111222233335555", LocalDate.of(2020,12,31),"1111"),new Cash(10000, Currency.RUR)));
        clientAccounts.add(new ClientAccount("0000000002","Ivan","Sidorov",new ClientCard("5555222233334444", LocalDate.of(2020,11,30),"2222"),new Cash(20000,Currency.RUR)));
        clientAccounts.add(new ClientAccount("0000000003","Sidr","Ivanov",new ClientCard("6666222233334444", LocalDate.of(2020,10,31),"3333"),new Cash(30000,Currency.RUR)));
        clientAccounts.add(new ClientAccount("0000000004","Petr","Petrov",new ClientCard("1111222233334444", LocalDate.of(2020,12,31),"1234"),new Cash(40000,Currency.RUR)));
        return clientAccounts;
    }

    public int findClientByCard(Transaction transaction, ArrayList<ClientAccount> accounts) throws CardNotFoundException {
        //вернуть индекс аккаунта или -1 в случае его отсутствия
        for (ClientAccount account : accounts) {
            if (transaction.getClient().getClientCard().getCardPAN().equals(account.getClientCard().getCardPAN())
                    && transaction.getClient().getClientCard().getCardPin().equals(account.getClientCard().getCardPin())
                    && transaction.getClient().getClientCard().getCardExp().equals(account.getClientCard().getCardExp())) {
                 return accounts.indexOf(account);
            }
        }
        throw new CardNotFoundException("Карта не найдена или введенный пин некорректен");
    }

    public Status checkCardBalance(Transaction transaction, ClientAccount account) throws ClientBalanceIsLowException {
        //проверить баланс карты
        if (transaction.getCash().getSum() <= account.getBalance().getSum()
                && transaction.getCash().getVal().equals(account.getBalance().getVal())) {
            return Status.SUCCESS;
        }
        throw new ClientBalanceIsLowException("Баланс карты недостаточен.");
    }

    public Status decreaseBalance (Transaction transaction, ClientAccount account){
        int oldBalance = account.getBalance().getSum();
        int newBalance = oldBalance - transaction.getCash().getSum();
        Currency val = account.getBalance().getVal();
        account.setBalance(new Cash(newBalance,val));
        return Status.SUCCESS;
    }

}
