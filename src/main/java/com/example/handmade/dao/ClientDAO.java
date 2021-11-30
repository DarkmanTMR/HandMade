package com.example.handmade.dao;

import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

public interface ClientDAO extends JpaRepository<Client, Integer> {
    Client findByName (String name);

    Client findByActivationToken(String activationToken);

    Client findByNameAndPassword(String name, String password);

    boolean existsClientByLoginToken(String loginToken);
//
//    @Transactional
//    Client saveClient(@RequestBody Client client);
//
//    @Transactional
//    List<Client> allClients(HttpServletRequest httpServletRequest);
//
//    @Transactional
//    Client editClient(@RequestBody Client clientFromRequest);
//
//    @Transactional
//    void deleteClient(@PathVariable int id);
//
//    @Transactional
//    List<Order> getClientsOrders(@PathVariable int id);
//
//    @Transactional
//    WishList getClientsWishList(@PathVariable int id);
//
//    @Transactional
//    void activate(@PathVariable String token);
//
//    @Transactional
//    ResponseEntity<String> login(@RequestBody Client requestClient);
}
