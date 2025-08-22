package com.app.pizza.Application.UseCases.user.Interfaces;

import com.app.pizza.Domain.Models.User;
import com.app.pizza.Infrastructure.PersistanceModels.UserPersistenceModel;

public interface RegisterUser <E extends User>{
    //User create(User user);
    E create(E user);

}
