package com.example.handmade.dao;

import com.example.handmade.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientDetailsServiceImplementation implements UserDetailsService {
    private ClientDAO clientDAO;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Client client = clientDAO.findByName(name);
        return client;
    }
}
