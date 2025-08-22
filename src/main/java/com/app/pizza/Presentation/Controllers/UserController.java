package com.app.pizza.Presentation.Controllers;

import com.app.pizza.Domain.Models.User;
import com.app.pizza.Presentation.DTOs.*;

public interface UserController {
    <E extends User, Req extends UserSignUpRequest> UserSignUpResponse signUp(Req signUpRequest);
    <E extends User, Res extends UserSignInResponse> Res signIn(UserSignInRequest signInRequest);
    void updateAccount();
    void deleteAccount();
}
