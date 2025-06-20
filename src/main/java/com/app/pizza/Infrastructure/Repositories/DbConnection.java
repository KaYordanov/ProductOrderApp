package com.app.pizza.Infrastructure.Repositories;

public interface DbConnection {

    // може и да е клас, трябва да измисля накаква абстракция за да не преизползвам код
    String url = "jdbc:mysql://localhost:3306/pizzadb";
    String user = "root";
    String password = "123";
}
