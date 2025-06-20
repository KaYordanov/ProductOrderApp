package com.app.pizza.Application.RepositoriesInterfaces;

import com.app.pizza.Domain.Models.Pizza;

import java.util.List;

public interface IPizzaRepository {
    public Pizza getPizzaByName(String pizzaName);
}
