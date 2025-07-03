package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Abstractions.User;

import java.time.LocalDate;

public class Customer extends User {
    private String address;

    public Customer(String fullName, String email, String password, int age, String phoneNumber, String address) {
        super(fullName, email, password, age, phoneNumber);
        this.address = address;
    }

    public Customer(long id, String fullName, String email, String password, int age, String phoneNumber, LocalDate registrationDate, String address) {
        super(id, fullName, email, password, age, phoneNumber, registrationDate);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}