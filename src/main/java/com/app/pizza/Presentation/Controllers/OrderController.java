package com.app.pizza.Presentation.Controllers;

import com.app.pizza.Application.ApplicationServices.ServicesInterfaces.ICreateOrder;
import com.app.pizza.Domain.Models.Order;

public class OrderController implements BaseController{
    ICreateOrder createOrder;

    public OrderController(ICreateOrder createOrder) {
        this.createOrder = createOrder;
    }


    // Employees functionality

    public void getOrderByStatus(){}

    public void modifyOrderStatus(int orderId, String status){}


    // Customer functionality

    public void createOrder(OrderRecord orderRecord){}

    public void modifyOrder(){}

    public void cancelOrder(){
        // трябва да се вземат всички поръчки, да се намери поръчката на този потребител и да се изтрие, и да се върнат в базата
    }

    public void getOrdersByCustomerId(int customerId) {}

    public void getOrderById(int id){}

    public void getOrderStatus(int orderId) {}
}
