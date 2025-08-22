package com.app.pizza.Application.RepositoryInterfaces;

import com.app.pizza.Domain.Models.User;
import com.app.pizza.Infrastructure.PersistanceModels.UserPersistenceModel;

import java.util.Map;

public interface MySqlUserRepository {
    User createNewUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, Map<>); // подавам името на колоната и самата нова стойност, за това ми трябва някакъв generic map. Другия вариант е чрез използването на id да вземем дадения User обект и да

    <E extends User> E getUserById(Long id);

    Long validateLogInCredentitals(String email, String password);

    <E extends User, P extends UserPersistenceModel> E getUser(String email, String password);
}
