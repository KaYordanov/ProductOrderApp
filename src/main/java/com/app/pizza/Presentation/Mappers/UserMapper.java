package com.app.pizza.Presentation.Mappers;

import com.app.pizza.Domain.Models.User;
import com.app.pizza.Presentation.DTOs.UserSignInResponse;
import com.app.pizza.Presentation.DTOs.UserSignUpRequest;
import com.app.pizza.Presentation.DTOs.UserSignUpResponse;

public interface UserMapper<E extends User, Req extends UserSignUpRequest, Res extends UserSignInResponse> {
    E toEntity(Req request);
    UserSignUpResponse toSignUpResponseDTO(E entity);// май няма да връща entity, о скоро boolean, някаква индикация за успех трябва
    Res toSignInResponseDTO(E entity);
}

