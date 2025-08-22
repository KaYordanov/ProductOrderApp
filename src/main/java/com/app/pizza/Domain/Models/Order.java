package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Enums.OrderStatus;
import com.app.pizza.Domain.Enums.OrderDeliveryType;
import com.app.pizza.Domain.Enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private long orderID;
    private Customer customer;
    private DeliveryEmployee deliveryEmployee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private OrderDeliveryType orderDeliveryType;
    private String address;
    private List<OrderItem> orderItems;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;
    private double totalSum; // totalSum ще бъде със сетър, който ще бъде ползван след изчисляването и потенциалното намаление
    private String notes;    // like 'leave at door' or 'no mushrooms'
    private boolean discounted;

    public Order(){}

    public Order(long orderID, Customer customer, DeliveryEmployee deliveryEmployee, LocalDateTime createdAt, LocalDateTime updatedAt, OrderDeliveryType orderDeliveryType, String address, List<OrderItem> orderItems, PaymentMethod paymentMethod, OrderStatus orderStatus, double totalSum, String notes) {
        this.orderID = orderID;
        this.customer = customer;
        this.deliveryEmployee = deliveryEmployee;
        this.createdAt = (createdAt != null) ? createdAt : LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.orderDeliveryType = orderDeliveryType;
        this.address = address;
        this.orderItems = orderItems;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.totalSum = calculateTotalSum(orderItems);
        this.notes = notes;
    }

    private double calculateTotalSum(List<OrderItem> items){
        return items.stream()
                    .mapToDouble(OrderItem::getTotalAmount)
                    .sum();
    }
}
