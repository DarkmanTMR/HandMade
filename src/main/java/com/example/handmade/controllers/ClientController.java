package com.example.handmade.controllers;


import com.example.handmade.dao.ClientDAO;
import com.example.handmade.helpers.ClientHelper;
import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.models.WishList;
import com.example.handmade.services.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientController {
    private ClientDAO clientDAO;
    private MailService mailService;
    private ClientHelper clientHelper;

    @PostMapping
    private Client saveClient(@RequestBody Client client){
        return clientDAO.save(client);
    }


    @PostMapping("/registration")
    public void clientRegistration(@RequestBody Client client){
          client.setActivationToken(clientHelper.tokenizer(client, "bobobo"));
        clientDAO.save(client);
            mailService.sendMessage(client);
    }

    @GetMapping("/activate/{token}")
    public void activate (@PathVariable String token) {
    Client client = clientDAO.findByAuthToken(token);
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
