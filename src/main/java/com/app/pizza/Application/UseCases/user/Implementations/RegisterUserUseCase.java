package com.app.pizza.Application.UseCases.user.Implementations;

import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Application.UseCases.user.Interfaces.RegisterUser;
import com.app.pizza.Domain.Abstractions.User;
import com.app.pizza.Domain.Models.Customer;

public class RegisterUserUseCase implements RegisterUser {
    MySqlUserRepository userRepository;

    public RegisterUserUseCase(MySqlUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(Customer customer) {
        // validations !!!

        userRepository.createNewUser(customer);


    }
}
