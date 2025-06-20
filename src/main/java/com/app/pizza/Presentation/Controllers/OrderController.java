package com.app.pizza.Presentation.Controllers;

import com.app.pizza.Application.ApplicationServices.ServicesInterfaces.ICreateOrder;
import com.app.pizza.Domain.Models.Order;

public class OrderController implements BaseController{
    ICreateOrder createOrder;

    public OrderController(ICreateOrder createOrder) {
        this.createOrder = createOrder;
    }

    public Order createOrder(OrderRecord orderRecord){
        Order order = createOrder.placeOrder(orderRecord);
        return order; // рябва да върна нещо, което да бъде валидирано, че
                      // реално поръчката е създадена успешно
    }
}
