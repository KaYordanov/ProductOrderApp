package com.app.pizza.Application.UseCases.user.Implementations;

import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Application.UseCases.user.Interfaces.UpdateUser;
import com.app.pizza.Domain.Models.User;

import java.util.Map;

public class UpdateUserUseCase implements UpdateUser {
    MySqlUserRepository userRepository;

    // constructor

    public <E extends User> E update(Long id, Map<String, Object> updateData){
        // business validation of password and email and then pass

        E user = userRepository.getUserById(id);


    }
}
