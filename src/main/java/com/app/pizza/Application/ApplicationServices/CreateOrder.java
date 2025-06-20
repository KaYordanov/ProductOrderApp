package com.app.pizza.Application.ApplicationServices;

import com.app.pizza.Application.ApplicationServices.ServicesInterfaces.ICreateOrder;
import com.app.pizza.Application.RepositoriesInterfaces.IOrderRepository;
import com.app.pizza.Application.RepositoriesInterfaces.IPizzaRepository;
import com.app.pizza.Domain.Models.Order;

public class CreateOrder implements ICreateOrder {
    private final IOrderRepository orderRepository;
    private final IPizzaRepository pizzaRepository;


    public Order placeOrder(OrderRecord request){
        // тук си създавам обекта, за да не експоузвам нагоре
        Order order = new Order(request.address(), request.Map<Pizza, Integer> );
        // Order order = new Order(request.address(), request.orderLines());
        orderRepository.saveOrderToDb(order);
        return order;
    }
