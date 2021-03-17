package ru.sherenkov.atmproject.server.processing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sherenkov.atmproject.server.processing.AccountDTO;
import ru.sherenkov.atmproject.server.processing.ClientDTO;
import ru.sherenkov.atmproject.server.processing.entity.Account;
import ru.sherenkov.atmproject.server.processing.entity.Client;
import ru.sherenkov.atmproject.server.processing.exception.ClientNotFoundException;
import ru.sherenkov.atmproject.server.processing.repository.ClientCrudRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientCrudRepository clientCrudRepository;

    public ClientDTO getClientBalance(Long id) {
        Client client = clientCrudRepository.findById(id)
                    .orElseThrow(ClientNotFoundException::new);

        Set<Account> accountSet = client.getAccounts();
        List<AccountDTO> accountDTOSet = new ArrayList<>();

        for (Account account : accountSet) {

            accountDTOSet.add(new AccountDTO(account.getCardPan(),account.getCardPin(),
                    account.getCardExp(), account.getBalance()));
        }
        ClientDTO result = new ClientDTO(client.getId().intValue(),
                client.getFirstName(),client.getLastName(),
                accountDTOSet);

        return result;
    }

    public List<ClientDTO> getAllClients() {
        Iterable<Client> clientIterable = clientCrudRepository.findAll();
        List<ClientDTO> clients = new ArrayList<>();

        clientIterable.forEach(
                client -> {
                    Set<Account> accountSet = client.getAccounts();
                    List<AccountDTO> accountDTOSet = new ArrayList<>();

                    for (Account account : accountSet) {

                        accountDTOSet.add(new AccountDTO(account.getCardPan(),
                                account.getCardPin(),account.getCardExp(),
                                account.getBalance()));
                    }
                    clients.add(new ClientDTO(client.getId().intValue(),
                            client.getFirstName(),client.getLastName(),
                            accountDTOSet));
                }
        );

        return clients;
    }
}
