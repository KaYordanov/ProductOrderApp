package com.app.pizza.Infrastructure.Mappers;

import com.app.pizza.Domain.Models.User;
import com.app.pizza.Domain.Enums.UserType;
import com.app.pizza.Infrastructure.PersistanceModels.UserPersistenceModel;

public class UserPersistenceMapperProvider {
    public static <E extends User, P extends UserPersistenceModel> UserPersistenceMapper<E, P> getMapper(UserType user_type){
        return switch (user_type) {
            case CUSTOMER -> (UserPersistenceMapper<E, P>) new CustomerPersistenceMapper();
            case DELIVERY -> (UserPersistenceMapper<E, P>) new DeliveryEmployeePersistenceMapper();
            case ON_SITE -> (UserPersistenceMapper<E, P>) new OnSiteEmployeePersistenceMapper();
            default -> throw new IllegalArgumentException("Unsupported user type");
        };
    }


}
