package com.example.handmade.services;


import com.example.handmade.dao.ClientDAO;
import com.example.handmade.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClientService  {
    private ClientDAO clientDAO;

    public Client save(Client client) {
         return clientDAO.save(client);
    }

    public Optional<Client> findById(int id) {
        Optional<Client> client = clientDAO.findById(id);
        if (!client.isPresent()) {
            throw new NullPointerException("John Doe");
        }
        return client;
    }

    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    public void deleteById(int id) {
        clientDAO.deleteById(id);
    }


}
