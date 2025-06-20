package com.app.pizza.Application.ApplicationServices.ServicesInterfaces;

import com.app.pizza.Domain.Models.Order;

public interface ICreateOrder {
    public Order placeOrder(OrderRecord request);
}
