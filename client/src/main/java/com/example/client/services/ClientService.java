package com.example.client.services;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) throws Exception {
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new Exception("Client not found");
        }
    }

    public Client addClient(Client client) {
        return repository.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) throws Exception {
        Optional<Client> existingClient = repository.findById(id);
        if (existingClient.isPresent()) {
            Client clientToUpdate = existingClient.get();
            clientToUpdate.setUsername(updatedClient.getUsername());
            clientToUpdate.setEmail(updatedClient.getEmail());
            clientToUpdate.setPassword(updatedClient.getPassword());
            clientToUpdate.setEntreprise(updatedClient.isEntreprise());
            return repository.save(clientToUpdate);
        } else {
            throw new Exception("Client not found");
        }
    }

    public void deleteClient(Long id) throws Exception {
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new Exception("Client not found");
        }
    }
}
