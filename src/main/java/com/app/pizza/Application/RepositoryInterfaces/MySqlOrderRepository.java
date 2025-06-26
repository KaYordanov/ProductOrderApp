package com.app.pizza.Application.RepositoryInterfaces;

import com.app.pizza.Domain.Models.Order;

public interface MySqlOrderRepository {
    public void saveOrderToDb(Order order);
    public void retrieveOrderByID(int id);
}
