package com.app.pizza.Application.UseCases.user.Implementations;

import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Application.UseCases.user.Interfaces.RetrieveUser;
import com.app.pizza.Domain.CustomExceptions.ApplicationException;
import com.app.pizza.Domain.CustomExceptions.UserNotFoundException;
import com.app.pizza.Domain.CustomExceptions.WrongEmailOrPasswordException;
import com.app.pizza.Domain.Models.User;
import com.app.pizza.Infrastructure.CustomExceptions.DatabaseAccessException;

public class RetrieveUserUseCase implements RetrieveUser {
    MySqlUserRepository userRepository;

    // constructor

    @Override
    public <E extends User> E retrieveByEmailAndPassword(String email, String password) throws ApplicationException {
        // business validation of password and email and then pass

        try {
            Long returned_id = userRepository.validateLogInCredentitals(email, password); // here i catch and throw business-level exceptions

            return userRepository.getUserById(returned_id);

        } catch (UserNotFoundException e){
            throw new WrongEmailOrPasswordException("Wrong email or password");
        } catch (DatabaseAccessException e){
            throw new ApplicationException("System error during login");
        }
    }
}
