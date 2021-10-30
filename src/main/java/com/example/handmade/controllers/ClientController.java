package com.example.handmade.controllers;


import com.example.handmade.dao.ClientDAO;
import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.models.WishList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientController {
    private ClientDAO clientDAO;

    @PostMapping
    private Client saveClient(@RequestBody Client client){
        return clientDAO.save(client);
    }

    @GetMapping("/{id}")
    public  Client getClient(@PathVariable int id){
        return clientDAO.findById(id).orElse(new Client("John","Doe"));
    }

    @GetMapping
    public List<Client> allClients(){
        return clientDAO.findAll();
    }

    @PatchMapping
    public Client editClient(@RequestBody Client clientFromRequest){
        Client clientFromDB = clientDAO.getById(clientFromRequest.getId());
        return clientDAO.save(clientFromDB);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id){
        clientDAO.deleteById(id);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getClientsOrders(@PathVariable int id){
        return clientDAO.findById(id).get().getOrders();
    }

    @GetMapping("/{id}/wishList")
    public WishList getClientsWishList(@PathVariable int id){
        return clientDAO.findById(id).get().getWishlist();
    }

}