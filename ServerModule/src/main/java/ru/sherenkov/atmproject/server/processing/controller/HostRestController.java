package ru.sherenkov.atmproject.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.sherenkov.atmproject.common.messages.Request;
import ru.sherenkov.atmproject.common.messages.ResponseAccounts;
import ru.sherenkov.atmproject.common.messages.ResponseClients;
import ru.sherenkov.atmproject.server.processing.exception.HostNotFoundException;
import ru.sherenkov.atmproject.server.processing.service.ClientService;

@RestController
@AllArgsConstructor
@Log
public class HostRestController {

    private ClientService clientService;

    @GetMapping("/hosts")
    public String getHostsInfo() {
        return "{data: \"1 host available\"}";
    }

    @GetMapping("/hosts/{hostId}")
    public String getHostInfo(@PathVariable Long hostId) {
        if (hostId == 1) {
            return "{data: \"Host " + hostId + " ready\"}";
        }else{
            return "{data: \"Host " + hostId + " not ready\"}";
        }
    }

    @PostMapping("/hosts/{hostId}/clients")
    public ResponseClients getClientsInfo(@PathVariable Long hostId) {

        if (hostId != 1) {
            throw new HostNotFoundException();
        }
        log.info("All clients request");
        ResponseClients response = new ResponseClients(clientService.getAllClients());
        log.info(response.toString());

        return response;
    }

    @PostMapping("/hosts/{hostId}/clients/{clientId}")
    public ResponseAccounts getBalance(@PathVariable("hostId") Long hostId,
                                       @PathVariable("clientId") Long clientId,
                                       @RequestBody Request request) {
        if (hostId != 1) {
            throw new RuntimeException("Host " + hostId + " is not ready!");
        }

        log.info(request.toString());
        ResponseAccounts response = new ResponseAccounts(clientService.getClientBalance(clientId).getFirstName(),
                clientService.getClientBalance(clientId).getLastName(),
                clientService.getClientBalance(clientId).getAccountDTO());
        log.info(response.toString());
        return response;
    }
}
