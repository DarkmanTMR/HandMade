package com.example.handmade.controllers;


import com.example.handmade.dao.ClientDAO;
import com.example.handmade.helpers.ClientHelper;
import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.models.OrderStatus;
import com.example.handmade.models.WishList;
//import com.example.handmade.services.ClientService;
import com.example.handmade.services.MailService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@EnableSwagger2
@Service
@RestController
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:4200"})

public class ClientController {
    private ClientDAO clientDAO;
    private MailService mailService;
    private ClientHelper clientHelper;
    private PasswordEncoder passwordEncoder;
//    private ClientService clientService;


    @PostMapping
    private Client saveClient(@RequestBody Client client) {
        return clientDAO.save(client);
    }


    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) {
        return clientDAO.findById(id).orElse(new Client("John", "Doe"));
    }

    @GetMapping
    public List<Client> allClients(HttpServletRequest httpServletRequest) {
    String authenticationHeader = httpServletRequest.getHeader("Authentication");
    String bearer = authenticationHeader.replace("Bearer ", "");
    if (clientDAO.existsClientByLoginToken(bearer)){
        return clientDAO.findAll();
    }
    return null;
}

    @PatchMapping
    public Client editClient(@RequestBody Client clientFromRequest) {
        Client clientFromDB = clientDAO.getById(clientFromRequest.getId());
        return clientDAO.save(clientFromDB);
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

    @GetMapping("/activate/{token}")
    public void activate(@PathVariable String token) {
        Client client = clientDAO.findByActivationToken(token);
        if (!client.isActivated()) {
            client.setActivated(true);
            clientDAO.save(client);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Client requestClient) {
        Client client = clientDAO.findByNameAndPassword(requestClient.getName(), requestClient.getPassword());
        String bubuToken = clientHelper.tokenizer(client, "bubu");
        client.setLoginToken(bubuToken);
        clientDAO.save(client);

        if (client != null) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("token", bubuToken);
            ResponseEntity<String> responseEntity = new ResponseEntity<>("login in fine", httpHeaders, HttpStatus.OK);
            return responseEntity;
        }
        return new ResponseEntity<String>("wrong credentials", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/registration")
    public void registration (@RequestBody Client client){
    String encode = passwordEncoder.encode(client.getPassword());
    client.setPassword(encode);
    clientDAO.save(client);
    }

}
