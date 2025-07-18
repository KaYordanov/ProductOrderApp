package com.app.pizza.Application.UseCases.user.Implementations;

import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Application.UseCases.user.Interfaces.RetrieveUser;
import com.app.pizza.Domain.Abstractions.User;

public class RetrieveUserUseCase implements RetrieveUser {
    MySqlUserRepository userRepository;

    @Override
    public User retrieve(String email, String password){
        // business validation of password and email and then pass

        return userRepository.getUser(email, password);
    }
}
