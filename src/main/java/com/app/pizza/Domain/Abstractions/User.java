package com.app.pizza.Domain.Abstractions;

import java.time.LocalDate;

public abstract class User {
    private long id;
    private String fullName;
    private String email;
    private String password;
    private int age;
    private String phoneNumber;
    private LocalDate registrationDate;
}
