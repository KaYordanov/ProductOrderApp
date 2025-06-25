package com.app.pizza.Application.RepositoriesInterfaces;

public interface MySqlUserRepository {
    public void loadUserById(long id);
    public void loadUserByEmailAndPassword(String email, String password);
}
