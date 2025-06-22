package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Abstractions.PizzaSize;

public class Pizza {
    private int pizzaId;
    private String name;
    private double price;
    private String description;
    private PizzaSize size;

    public Pizza() {}


    public Pizza(int pizzaId, String name, double price, String description, PizzaSize size) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
