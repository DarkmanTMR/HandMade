package com.example.handmade.helpers;

import com.example.handmade.models.Client;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class ClientHelper {

    public String tokenizer(Client client, String secret){
        return Jwts.builder()
                .setSubject(client.getName())
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

}
