package com.homeproject.homeproject.controller;

import com.homeproject.homeproject.model.ClientDto;
import com.homeproject.homeproject.repository.Client;
import com.homeproject.homeproject.service.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientServiceImpl clientService;

    @GetMapping("/allClient")
    @ResponseStatus(OK)
    public List<ClientDto> findAllClient() {
        return clientService.getAllClientDto();
    }

    @PostMapping("/newClient")
    public void createClient(@RequestBody ClientDto clientDto) {
        clientService.createClient(clientDto);
    }

    @GetMapping(value = "/client/{id}")
    public Client readClientById(@PathVariable("id") UUID id) {
        return clientService.readClientById(id);
    }

    @PutMapping("/editClient")
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }

    @PatchMapping("/updateClient")
    public void updateClient2(@RequestBody Client client) {
        clientService.updateClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
    }
}
