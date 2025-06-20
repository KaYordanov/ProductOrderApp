package com.app.pizza.Domain.Models;

public class OrderLine {
    private Pizza pizza;
    private int quantity;

    public OrderLine(Pizza pizza, int quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return pizza.getPrice() * quantity;
    }
}
