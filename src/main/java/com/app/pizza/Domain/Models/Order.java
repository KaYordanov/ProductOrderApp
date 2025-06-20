package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Abstractions.OrderStatus;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Order {
    private int orderID;
    private Date orderDate;
    private String address;
    private OrderStatus orderStatus;
    private int customerID;

    //private List<OrderLine> orderLines;
    private Map<Pizza, Integer> orderList;
    private double totalSum;


    public Order(int customerID, String address, Map<Pizza, Integer> orderList) {
        this.address = address;
        this.orderDate = //  code to set it to today's
        this.customerID = customerID;
        this.orderList = orderList;
        this.orderStatus = // hardcode-вам да е първи статус и вече Employee да може да променя статуа, може би??
        this.totalSum =
    }



    /*
    public Order(String address, int customerID, List<OrderLine> orderLines) {
        this.address = address;
        this.orderDate = //  code to set it to today's
        this.customerID = customerID;
        this.orderLines = orderLines;
        this.orderStatus = // hardcode-вам да е първи статус и вече Employee да може да променя статуа, може би??
        this.totalSum = orderLines.stream().mapToDouble(OrderLine::getTotalPrice).sum();
    }
     */

    private
}
