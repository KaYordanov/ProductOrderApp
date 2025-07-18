package com.app.pizza.Presentation.Controllers;

import com.app.pizza.Application.UseCases.user.Interfaces.RegisterUser;
import com.app.pizza.Application.UseCases.user.Interfaces.DeleteUser;
import com.app.pizza.Application.UseCases.user.Interfaces.RetrieveUser;
import com.app.pizza.Application.UseCases.user.Interfaces.UpdateUser;
import com.app.pizza.Domain.Abstractions.User;
import com.app.pizza.Presentation.DTOs.UserSignInRequest;
import com.app.pizza.Presentation.DTOs.UserSignInResponse;
import com.app.pizza.Presentation.DTOs.UserSignUpRequest;
import com.app.pizza.Presentation.DTOs.UserSignUpResponse;
import com.app.pizza.Presentation.Mappers.UserMapper;

public class UserControllerImplementation implements UserController{
    RegisterUser registerUser;
    RetrieveUser retrieveUser;
    UpdateUser updateUser;
    DeleteUser deleteUser;
    UserMapper userMapper;

    public UserControllerImplementation(RegisterUser registerUser, RetrieveUser retrieveUser, UpdateUser updateUser, DeleteUser deleteUser, UserMapper userMapper) {
        this.registerUser = registerUser;
        this.retrieveUser = retrieveUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
        this.userMapper = userMapper;
    }

    @Override
    public UserSignUpResponse signUp(UserSignUpRequest signUpRequestDTO) {
        User customer = userMapper.toEntity(signUpRequestDTO);
        UserSignUpResponse signUpResponseDTO = userMapper.toSignUpResponseDTO(registerUser.create(customer)); //finish responseDTO and mapper

        return signUpResponseDTO;
    }

    // решения за проблема на регистриране на различни потребители

    // вариант 1 - overload на signUp() или overload в мапъра на toEntity() (UserSignUpRequestDTO да е само абстрактно и да има конкретни dto-та)
    @Override
    public UserSignInResponse signIn(UserSignInRequest signInRequestDTO) {
        String email = signInRequestDTO.getEmail();
        String password = signInRequestDTO.getPassword();

        // ВАЛИДАЦИЯ НА ТОВА НИВО??

        return userMapper.toSignInResponseDTO(retrieveUser.retrieve(email, password));

    }

    @Override
    public void updateAccount() {

    }

    @Override
    public void deleteAccount() {

    }

}
