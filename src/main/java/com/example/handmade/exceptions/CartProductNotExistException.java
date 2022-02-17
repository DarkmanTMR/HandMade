package com.example.handmade.exceptions;

public class CartProductNotExistException extends IllegalArgumentException{
    public CartProductNotExistException(String msg){
        super(msg);
    }
}
