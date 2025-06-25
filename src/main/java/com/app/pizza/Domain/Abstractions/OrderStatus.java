package com.app.pizza.Domain.Abstractions;

public enum OrderStatus {
    PENDING,
    CONFIRMED,
    IN_PREPARATION,
    READY_FOR_PICKUP,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED
}
