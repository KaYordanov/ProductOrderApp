package com.app.pizza.Domain.CustomExceptions;

import com.app.pizza.Domain.Models.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
