package com.app.pizza.Domain.CustomExceptions;

import com.app.pizza.Infrastructure.CustomExceptions.DatabaseAccessException;

public class ApplicationException extends Exception{
    public ApplicationException(String message){
        super(message);
    }
}
