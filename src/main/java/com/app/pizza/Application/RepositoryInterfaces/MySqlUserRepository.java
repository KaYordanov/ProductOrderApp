package com.app.pizza.Application.RepositoryInterfaces;

import com.app.pizza.Domain.Abstractions.User;

import java.util.Map;

public interface MySqlUserRepository {
    User createNewUser(User user);
    void deleteUser(long id);
    void updateUser(long id, Map<>); // подавам името на колоната и самата нова стойност, за това ми трябва някакъв generic map
    User getUser(String email, String password);
}
