package com.app.pizza.Domain.Models;

public class OrderItem {
    private long id;
    private int quantity;
    private Product product;
    private double totalAmount;

    public OrderItem(long id, int quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.totalAmount = product.getPrice() * quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
