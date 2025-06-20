package com.app.pizza.Application.RepositoriesInterfaces;

import com.app.pizza.Domain.Models.Order;

public interface IOrderRepository {
    public void saveOrderToDb(Order order);
    public void retrieveOrderByID(int id);
}
