package com.example.handmade.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Table(name = "picture")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ProductId;
    private String name;
}
