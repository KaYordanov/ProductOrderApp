package com.app.pizza.Presentation.Mappers;

import com.app.pizza.Domain.Abstractions.User;
import com.app.pizza.Domain.Models.Customer;
import com.app.pizza.Presentation.DTOs.UserSignInRequest;
import com.app.pizza.Presentation.DTOs.UserSignInResponse;
import com.app.pizza.Presentation.DTOs.UserSignUpRequest;
import com.app.pizza.Presentation.DTOs.UserSignUpResponse;

public class UserMapperImplementation implements UserMapper {
    public User toEntity(UserSignUpRequest signUpDto){
        return new Customer(signUpDto.getFullName(), signUpDto.getEmail(), signUpDto.getPassword(), signUpDto.getAge(), signUpDto.getPhoneNumber(), signUpDto.getAddress());
    }

    public User toEntity(UserSignInRequest signInDto){

    }

    public UserSignUpResponse toSignUpResponseDTO(User user){

    }

    public UserSignInResponse toSignInResponseDTO(User user){

    }
}
