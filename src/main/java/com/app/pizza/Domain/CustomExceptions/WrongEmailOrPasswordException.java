package com.app.pizza.Domain.CustomExceptions;

public class WrongEmailOrPasswordException extends RuntimeException{
    public WrongEmailOrPasswordException(String message){
        super(message);
    }
}
