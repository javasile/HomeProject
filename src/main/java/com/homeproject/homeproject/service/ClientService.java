package com.homeproject.homeproject.service;

import com.homeproject.homeproject.model.ClientDto;
import com.homeproject.homeproject.repository.Client;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<ClientDto> getAllClientDto();

    void createClient(@Valid ClientDto clientDto);

    Client readClientById(UUID id);

    Client updateClient(Client client);

    void deleteClient(UUID id);
}
