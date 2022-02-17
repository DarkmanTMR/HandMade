package com.example.handmade.controllers;


import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:4200"})

public class ClientController {
      private ClientService clientService;
//    private MailService mailService;
//    private ClientHelper clientHelper;

    @PostMapping
    private Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }


    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.findClientById(id);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    @PatchMapping
    public Client editClient(@RequestBody Client clientFromRequest) {
       return clientService.editClient(clientFromRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteById(id);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getClientsOrders(@PathVariable int id) {
        return clientService.findOrdersByClientId(id);
    }
//
//    @GetMapping("/{id}/wishList")
//    public WishList getClientsWishList(@PathVariable int id) {
//        return clientService.findById(id).get().getWishlist();
//    }

//    @PostMapping("/registration")
//    public void clientRegistration(@RequestBody Client client) {
//        client.setActivationToken(clientHelper.tokenizer(client, "bobobo"));
//        clientDAO.save(client);
//        mailService.sendMessage(client);
//    }
//
//    @GetMapping("/activate/{token}")
//    public void activate(@PathVariable String token) {
//        Client client = clientDAO.findByActivationToken(token);
//        if (!client.isActivated()) {
//            client.setActivated(true);
//            clientDAO.save(client);
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Client requestClient) {
//        Client client = clientDAO.findByNameAndPassword(requestClient.getName(), requestClient.getPassword());
//        String bubuToken = clientHelper.tokenizer(client, "bubu");
//        client.setLoginToken(bubuToken);
//        clientDAO.save(client);
//
//        if (client != null) {
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add("token", bubuToken);
//            ResponseEntity<String> responseEntity = new ResponseEntity<>("login in fine", httpHeaders, HttpStatus.OK);
//            return responseEntity;
//        }
//        return new ResponseEntity<String>("wrong credentials", HttpStatus.UNAUTHORIZED);
//    }

}
