package ru.example.processing;

import ru.example.atm.*;
import ru.example.client.Account;
import ru.example.client.ClientCardFormatException;
import ru.example.processing.Exceptions.CardNotFoundException;
import ru.example.processing.Exceptions.ClientBalanceException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class TempOperations {

    public ArrayList<CustomerAccount> createAccounts(){
        ArrayList<CustomerAccount> customerAccounts = new ArrayList<>();
        customerAccounts.add(new CustomerAccount("1","Ivan","Ivanov",new Account("1111222233335555", LocalDate.of(2020, Month.DECEMBER,31),"1111"),new Cash(new BigDecimal(10000), Currency.RUR)));
        customerAccounts.add(new CustomerAccount("2","Ivan","Sidorov",new Account("5555222233334444", LocalDate.of(2020,Month.NOVEMBER,30),"2222"),new Cash(new BigDecimal(20000),Currency.RUR)));
        customerAccounts.add(new CustomerAccount("3","Sidr","Ivanov",new Account("6666222233334444", LocalDate.of(2020,Month.OCTOBER,31),"3333"),new Cash(new BigDecimal(30000),Currency.RUR)));
        customerAccounts.add(new CustomerAccount("4","Petr","Petrov",new Account("1111222233334444", LocalDate.of(2021,Month.DECEMBER,31),"1234"),new Cash(new BigDecimal(40000),Currency.RUR)));
        return customerAccounts;
    }

    public int findClientByCard(Transaction transaction, ArrayList<CustomerAccount> accounts) throws CardNotFoundException {
        //вернуть индекс аккаунта или -1 в случае его отсутствия
        for (CustomerAccount account : accounts) {
            if (transaction.getClient().getAccount().getCardPAN().equals(account.getAccount().getCardPAN())
                    && transaction.getClient().getAccount().getCardPin().equals(account.getAccount().getCardPin())
                    && transaction.getClient().getAccount().getCardExp().equals(account.getAccount().getCardExp())) {
                 return accounts.indexOf(account);
            }
        }
        throw new CardNotFoundException("Карта не найдена или введенный пин некорректен");
    }

    public Status checkAccExp(Transaction transaction) throws ClientCardFormatException {
        if (transaction.getClient().getAccount().getCardExp().isAfter(LocalDate.now())) {
            return Status.SUCCESS;
        }
        throw new ClientCardFormatException(transaction.getClient().getAccount()+" is expired.");
    }

        public String checkDoubleRequest(Transaction transaction, Atm atm) {
            if (!atm.doubleRequest.add(transaction.getClient().getAccount())) {
                return ("Повторная операция по данному аккаунту.");
            }
            return "";
    }

    public Status checkBalance(Transaction transaction, CustomerAccount account) throws ClientBalanceException {
        //проверка баланса
        if (account.getBalance().getAmount().compareTo(transaction.getCash().getAmount()) >= 0
            && transaction.getCash().getVal().equals(account.getBalance().getVal())) {
            return Status.SUCCESS;
        }
        throw new ClientBalanceException("Баланс счета недостаточен.");
    }

    public Status decreaseBalance (Transaction transaction, CustomerAccount account) throws ClientBalanceException {
        //снятие со счета
        if (account.getBalance().getAmount().compareTo(transaction.getCash().getAmount()) >= 0
                && transaction.getCash().getVal().equals(account.getBalance().getVal())){
            account.setBalance(new Cash(account.getBalance().getAmount().subtract(transaction.getCash().getAmount()),account.getBalance().getVal()));
            return Status.SUCCESS;
        } else throw new ClientBalanceException("Баланс счета недостаточен. Операция не выполнена.");
    }

}
