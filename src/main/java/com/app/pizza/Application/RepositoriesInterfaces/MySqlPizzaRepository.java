package com.app.pizza.Application.RepositoriesInterfaces;

import com.app.pizza.Domain.Models.Product;

public interface MySqlPizzaRepository {
    public Product getPizzaByName(String pizzaName);
}
