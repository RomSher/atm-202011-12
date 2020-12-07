package ru.example.processing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.example.atm.Cash;
import ru.example.atm.Currency;
import ru.example.client.ClientCard;

import java.time.LocalDate;
import java.util.ArrayList;
@Data
@Getter
@AllArgsConstructor
public class ClientAccount {
    private final String ID;
    private final String firstName;
    private final String lastName;
    private ClientCard clientCard;

    @Setter
    private Cash balance;

    public static ArrayList<ClientAccount> createAccounts(){
        ArrayList<ClientAccount> clientAccounts = new ArrayList<>();
        clientAccounts.add(new ClientAccount("0000000001","Ivan","Ivanov",new ClientCard("1111222233335555", LocalDate.of(2020,12,31),"1111"),new Cash(10000, Currency.RUR)));
        clientAccounts.add(new ClientAccount("0000000002","Ivan","Sidorov",new ClientCard("5555222233334444", LocalDate.of(2020,11,30),"2222"),new Cash(20000,Currency.RUR)));
        clientAccounts.add(new ClientAccount("0000000003","Sidr","Ivanov",new ClientCard("6666222233334444", LocalDate.of(2020,10,31),"3333"),new Cash(30000,Currency.RUR)));
        clientAccounts.add(new ClientAccount("0000000004","Petr","Petrov",new ClientCard("1111222233334444", LocalDate.of(2020,12,31),"1234"),new Cash(40000,Currency.RUR)));
        return clientAccounts;
    }
 }

