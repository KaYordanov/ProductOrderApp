package com.app.pizza.Presentation.Controllers;

import com.app.pizza.Presentation.DTOs.UserSignInRequest;
import com.app.pizza.Presentation.DTOs.UserSignInResponse;
import com.app.pizza.Presentation.DTOs.UserSignUpRequest;
import com.app.pizza.Presentation.DTOs.UserSignUpResponse;

public interface UserController {
    UserSignUpResponse signUp(UserSignUpRequest signUpRequestDTO);
    UserSignInResponse signIn(UserSignInRequest signInRequestDTO);
    void updateAccount();
    void deleteAccount();
}
