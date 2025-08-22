package com.app.pizza.Infrastructure.CustomExceptions;

public class DatabaseAccessException extends RuntimeException{
    public DatabaseAccessException(String message){
        super(message);
    }
}
