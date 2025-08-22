package com.app.pizza.Application.UseCases.user.Implementations;

import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Application.UseCases.user.Interfaces.RegisterUser;
import com.app.pizza.Domain.Models.User;

public class RegisterUserUseCase implements RegisterUser {
    MySqlUserRepository userRepository;

    public RegisterUserUseCase(MySqlUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public <E extends User> E create(E user) {
        // data validation - check if email exists, other business related data checks

        if(userRepository.checkEmail(user.getEmail())){
            userRepository.createNewUser(user);
        }

        return
    }

    /*
    @Override
    public User create(User user) {
        // validations !!!

        userRepository.createNewUser(user);
    }

     */


}
