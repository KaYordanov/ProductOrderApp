package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Enums.ProductSize;

public class Product {
    private int pizzaId;
    private String name;
    private double price;
    private String description;
    private ProductSize size;

    public Product() {}


    public Product(int pizzaId, String name, double price, String description, ProductSize size) {
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

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

}
