package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Abstractions.OrderStatus;
import com.app.pizza.Domain.Abstractions.OrderType;
import com.app.pizza.Domain.Abstractions.PaymentMethod;

import java.time.LocalDate;
import java.util.Map;


public class Order {
    private long orderID;
    private String customerName;
    private LocalDate orderDate;
    private OrderType orderType;
    private String address;
    private String city;
    private String zipCode;
    private OrderStatus orderStatus;
    private long customerID;
    private Map<Pizza, Integer> orderList;
    private PaymentMethod paymentMethod;
    private double totalSum; // totalSum ще бъде със сетър, който ще бъде ползван след изчисляването и потенциалното намаление
    private String notes;    // like 'leave at door' or 'no mushrooms'
    private Long deliveryEmployeeId;
    private boolean discounted;


    // и тук станаха много полета, с Builder pattern ще го създавам

    /*
    public Order(long customerID, String customerName, String address, Map<Pizza, Integer> orderList) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.orderDate = LocalDate.now();
        this.customerID = customerID;
        this.orderList = orderList;
        this.orderStatus = // hardcode-вам да е първи статус и вече Employee да може да променя статуа, може би??
    }
    */
}
