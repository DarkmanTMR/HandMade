package com.example.handmade.exceptions;

public class OrderNotFoundException extends IllegalArgumentException{
    public OrderNotFoundException(String msg){
        super(msg);
    }
}
