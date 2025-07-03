package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Abstractions.Position;

import java.time.LocalDate;

public class OnSiteEmployee extends Employee{
    private Position position;

    public OnSiteEmployee(String fullName, String email, String password, int age, String phoneNumber, double salary, LocalDate hireDate, Position position) {
        super(fullName, email, password, age, phoneNumber, salary, hireDate);
        this.position = position;
    }

    public OnSiteEmployee(long id, String fullName, String email, String password, int age, String phoneNumber, LocalDate registrationDate, double salary, LocalDate hireDate, Position position) {
        super(id, fullName, email, password, age, phoneNumber, registrationDate, salary, hireDate);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
