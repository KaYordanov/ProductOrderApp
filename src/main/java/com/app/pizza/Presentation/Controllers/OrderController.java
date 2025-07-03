package com.app.pizza.Presentation.Controllers;

public class OrderController {
    // Use cases here

    // Constructor with use cases injected here

    public void getOrderById(long id){}
    public void getOrderByStatus(String orderStatus){} // the status String will be changed to Enum potentially
    public void updateOrderStatus(int orderId, String orderStatus){} // the status String will be changed to Enum potentially
    public void createOrder(){}
    public void getOrdersByCustomerId(int customerId) {}
    public void getPendingOrders(int customerID){}
    public void modifyOrder(){}
    public void cancelOrder(int orderId){}
    public void acceptOrderDelivery(){}
    public void rejectOrderDelivery(){}
}
