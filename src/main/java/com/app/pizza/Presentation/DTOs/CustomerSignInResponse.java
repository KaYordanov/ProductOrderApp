package com.app.pizza.Presentation.DTOs;

import com.app.pizza.Domain.Models.User;

public class CustomerSignInResponse extends UserSignInResponse{
    private Boolean success;
    private Long id;
    private String message;

}
