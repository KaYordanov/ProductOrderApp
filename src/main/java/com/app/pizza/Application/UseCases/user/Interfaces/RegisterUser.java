package com.app.pizza.Application.UseCases.user.Interfaces;

import com.app.pizza.Domain.Abstractions.User;

public interface RegisterUser {
    User create(User user);
}
