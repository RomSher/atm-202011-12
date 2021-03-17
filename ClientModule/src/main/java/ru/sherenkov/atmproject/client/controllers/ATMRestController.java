package ru.sherenkov.atmproject.client.controllers;

import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.sherenkov.atmproject.client.exception.ATMInternalErrorException;
import ru.sherenkov.atmproject.client.services.ATMService;
import ru.sherenkov.atmproject.common.messages.Request;
import ru.sherenkov.atmproject.common.messages.RequestTypes;


@RestController
@Log
public class ATMRestController {
    private ATMService atmService;
    /**
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Главная страница");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "страница About");
        return "about";
    }
    **/
    @GetMapping("/ATM")
    public String getATMsStatus() {
        return "1 ATM is ready.";
    }

    @GetMapping("/ATM/{ATMId}/clients")
    public String getAllClients(
            @PathVariable("ATMId") Long ATMId){

        log.info("All clients");

        if (ATMId != 1) {
            throw new ATMInternalErrorException("ATM internal Error");
        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity("http://127.0.0.1:8081/hosts/"+ATMId+"/clients","", String.class);
        log.info("responseEntityStr.getBody()" + responseEntityStr.getBody());
        return responseEntityStr.getBody();
    }

    @GetMapping("/ATM/{ATMId}/clients/{clientId}")
    public String getClientBalance(
            @PathVariable("ATMId") Long ATMId,
            @PathVariable("clientId") Long clientId){

        log.info("clientId " + clientId);

        if (ATMId != 1) {
            throw new ATMInternalErrorException("ATM internal Error");
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Request> request = new HttpEntity<>(new Request(1, "{\"clientId\":"+clientId+"}", RequestTypes.JSON));

        log.info("request.toString()" + request.toString());
        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity("http://127.0.0.1:8081/hosts/1/clients/" + clientId,
                        request, String.class);
        log.info("responseEntityStr.getBody()" + responseEntityStr.getBody());
        return responseEntityStr.getBody();
    }
}
