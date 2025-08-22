package com.app.pizza.Presentation.Mappers;

import com.app.pizza.Domain.Models.User;
import com.app.pizza.Presentation.DTOs.UserSignInResponse;
import com.app.pizza.Presentation.DTOs.UserSignUpRequest;

import static com.app.pizza.Domain.Enums.UserType.*;

public class UserMapperProvider {
    public static <E extends User, Req extends UserSignUpRequest> UserMapper<E, Req, ?> getMapper(Req request) {
        return switch (request.getUserType()) {
            case CUSTOMER -> (UserMapper<E, Req, ?>) new CustomerMapper();
            case DELIVERY -> (UserMapper<E, Req, ?>) new DeliveryMapper();
            case ON_SITE -> (UserMapper<E, Req, ?>) new OnSiteMapper();
            default -> throw new IllegalArgumentException("Unsupported request type");
        };
    }

    public static <E extends User, Res extends UserSignInResponse> UserMapper<E, ?, Res> getMapper(E entity) {
        return switch (entity.getUserType()) {
            case CUSTOMER -> (UserMapper<E, ?, Res>) new CustomerMapper();
            case DELIVERY -> (UserMapper<E, ?, Res>) new DeliveryMapper();
            case ON_SITE -> (UserMapper<E, ?, Res>) new OnSiteMapper();
            default -> throw new IllegalArgumentException("Unsupported entity type");
        };
    }

}
