package com.example.handmade.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "review")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "body")
    private String body;
    private int clientId;

    public Review(String body) {
        this.body = body;
    }
}
