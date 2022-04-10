package com.homeproject.homeproject.service;

import com.homeproject.homeproject.exceptions.MyPersonalExceptionBad;
import com.homeproject.homeproject.exceptions.MyPersonalExceptionFound;
import com.homeproject.homeproject.model.ClientDto;
import com.homeproject.homeproject.repository.Client;
import com.homeproject.homeproject.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<ClientDto> getAllClientDto() {
        return null;
    }

    @Override
    public void createClient(@Valid ClientDto clientDto) {
        Optional<Client> clientOp = clientRepository.findById(clientDto.getId());
        if (clientOp.isPresent()) {
            throw new MyPersonalExceptionBad("Client Already Exists!");
        }
    }

    @Override
    public Client readClientById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new MyPersonalExceptionFound("Client Not Found!"));
    }

    @Override
    public Client updateClient(Client client) {
        this.readClientById(client.getId());
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(UUID id) {
        this.readClientById(id);
        clientRepository.deleteById(id);
    }

}
