package com.app.pizza.Infrastructure.Mappers;

import com.app.pizza.Domain.Models.User;
import com.app.pizza.Infrastructure.PersistanceModels.UserPersistenceModel;

import java.util.Map;

public interface UserPersistenceMapper<E extends User, P extends UserPersistenceModel> {
    E toEntity(P persistenceModel);
    P toPersistenceModel(E user);
    P toPersistenceModel (Map<String, Object> userData);
}
