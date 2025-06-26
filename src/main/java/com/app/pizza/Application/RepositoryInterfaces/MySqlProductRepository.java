package com.app.pizza.Application.RepositoryInterfaces;

import com.app.pizza.Domain.Models.Product;

public interface MySqlProductRepository {
    public Product getPizzaByName(String pizzaName);
}
