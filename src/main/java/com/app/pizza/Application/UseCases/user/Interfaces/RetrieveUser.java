package com.app.pizza.Application.UseCases.user.Interfaces;

import com.app.pizza.Domain.Models.User;

public interface RetrieveUser {

    <E extends User> E retrieveByEmailAndPassword(String email, String password);
}
