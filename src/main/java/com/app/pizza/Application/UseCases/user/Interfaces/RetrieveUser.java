package com.app.pizza.Application.UseCases.user.Interfaces;

import com.app.pizza.Domain.Abstractions.User;

public interface RetrieveUser {
    User retrieve(String email, String password);
}
