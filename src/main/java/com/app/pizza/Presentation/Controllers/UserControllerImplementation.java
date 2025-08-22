package com.app.pizza.Presentation.Controllers;

import com.app.pizza.Application.UseCases.user.Interfaces.RegisterUser;
import com.app.pizza.Application.UseCases.user.Interfaces.DeleteUser;
import com.app.pizza.Application.UseCases.user.Interfaces.RetrieveUser;
import com.app.pizza.Application.UseCases.user.Interfaces.UpdateUser;
import com.app.pizza.Domain.CustomExceptions.WrongEmailOrPasswordException;
import com.app.pizza.Domain.Models.User;
import com.app.pizza.Presentation.DTOs.*;
import com.app.pizza.Presentation.Mappers.UserMapper;
import com.app.pizza.Presentation.Mappers.UserMapperProvider;

public class UserControllerImplementation implements UserController{
    RegisterUser registerUseCase;
    RetrieveUser retrieveUseCase;
    UpdateUser updateUserUseCase;
    DeleteUser deleteUserUseCase;

    public UserControllerImplementation(RegisterUser registerUseCase, RetrieveUser retrieveUseCase, UpdateUser updateUserUseCase, DeleteUser deleteUserUseCase) {
        this.registerUseCase = registerUseCase;
        this.retrieveUseCase = retrieveUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }


    @Override
    public <E extends User, Req extends UserSignUpRequest> UserSignUpResponse signUp(Req signUpRequest) {
        UserMapper<E, Req, ?> userMapper = UserMapperProvider.getMapper(signUpRequest); // CustomerSignRequest трябва да има user_type поле за да се извади нужния конкретен мапер
        E userEntity = userMapper.toEntity(signUpRequest);
        return userMapper.toSignUpResponseDTO((E) registerUseCase.create(userEntity));
    }


    @Override
    public <E extends User, Res extends UserSignInResponse> Res signIn(UserSignInRequest signInRequest){
        E userEntity = (E) retrieveUseCase.retrieve(signInRequest.getEmail(), signInRequest.getPassword());
        UserMapper<E, ?, Res> userMapper = UserMapperProvider.getMapper(userEntity);
        return userMapper.toSignInResponseDTO(userEntity);
    }

    @Override
    public void updateAccount() {

    }

    @Override
    public void deleteAccount() {

    }

}
