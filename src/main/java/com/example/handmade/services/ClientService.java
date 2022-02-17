package com.example.handmade.services;


import com.example.handmade.dao.ClientDAO;
import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClientService  {
    private ClientDAO clientDAO;

    public Client saveClient(Client client) {
         return clientDAO.save(client);
    }

    public Client findClientById(int id) {
        Optional<Client> client = clientDAO.findById(id);
        return clientDAO.findById(id).orElse(new Client("John", "Doe"));

    }

    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    public void deleteById(int id) {
        clientDAO.deleteById(id);
    }


    public Client editClient(Client clientFromRequest){
        Optional<Optional<Client>> clientFromDB = Optional.of(clientDAO.findById(clientFromRequest.getId()));
        return clientDAO.save(clientFromRequest);
    }

    public List<Order> findOrdersByClientId(int id) {
        return clientDAO.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST)).getOrders();
    }
}
