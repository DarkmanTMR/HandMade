package com.example.handmade.dao;

import com.example.handmade.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client, Integer> {

    Client findByActivationToken(String activationToken);

    Client findByNameAndPassword(String name, String password);

    boolean existsClientByLoginToken(String loginToken);
}
