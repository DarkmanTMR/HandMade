package com.example.handmade.controllers;


import com.example.handmade.dao.ClientDAO;
import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.models.WishList;
//import com.example.handmade.services.MailService;
//import com.example.handmade.helpers.ClientHelper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:4200"})

public class ClientController {
    private ClientDAO clientDAO;
//    private MailService mailService;
//    private ClientHelper clientHelper;

    @PostMapping
    private Client saveClient(@RequestBody Client client) {
        return clientDAO.save(client);
    }


    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) {
        return clientDAO.findById(id).orElse(new Client("John", "Doe"));
    }

    @GetMapping
    public List<Client> allClients(){
        return clientDAO.findAll();

//    public List<Client> allClients(HttpServletRequest httpServletRequest) {
//    String authenticationHeader = httpServletRequest.getHeader("Authentication");
//    String bearer = authenticationHeader.replace("Bearer ", "");
//    if (clientDAO.existsClientByLoginToken(bearer)){
//        return clientDAO.findAll();
//    }
//    return null;
}

    @PatchMapping
    public Client editClient(@RequestBody Client clientFromRequest) {
        Optional<Client> clientFromDB = clientDAO.findById(clientFromRequest.getId());
        return clientDAO.save(clientFromRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id) {
        clientDAO.deleteById(id);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getClientsOrders(@PathVariable int id) {
        return clientDAO.findById(id).get().getOrders();
    }

    @GetMapping("/{id}/wishList")
    public WishList getClientsWishList(@PathVariable int id) {
        return clientDAO.findById(id).get().getWishlist();
    }

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
