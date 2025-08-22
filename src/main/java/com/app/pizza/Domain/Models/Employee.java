package com.app.pizza.Domain.Models;

import java.time.LocalDate;

public class Employee extends User {
    private double salary;
    private LocalDate hireDate;

    public Employee(String fullName, String email, String password, int age, String phoneNumber, double salary, LocalDate hireDate) {
        super(fullName, email, password, age, phoneNumber);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee(long id, String fullName, String email, String password, int age, String phoneNumber, LocalDate registrationDate, double salary, LocalDate hireDate) {
        super(id, fullName, email, password, age, phoneNumber, registrationDate);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
