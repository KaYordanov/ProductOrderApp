package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Abstractions.PizzaSize;

public class Pizza {
    private int pizzaID;
    private double price;
    private String description;
    private PizzaSize size;

    public Pizza(int pizzaID, double price, String description, PizzaSize size) {
        this.pizzaID = pizzaID;
        this.price = price;
        this.description = description;
        this.size = size;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }
}
