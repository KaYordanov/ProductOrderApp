package com.app.pizza.Presentation.Mappers;

import com.app.pizza.Domain.Abstractions.User;
import com.app.pizza.Presentation.DTOs.UserSignInRequest;
import com.app.pizza.Presentation.DTOs.UserSignInResponse;
import com.app.pizza.Presentation.DTOs.UserSignUpRequest;
import com.app.pizza.Presentation.DTOs.UserSignUpResponse;

public interface UserMapper {
    public User toEntity(UserSignUpRequest signUpDto);

    public User toEntity(UserSignInRequest signIpDto);

    public UserSignUpResponse toSignUpResponseDTO(User user);

    public UserSignInResponse toSignInResponseDTO(User user);
}
