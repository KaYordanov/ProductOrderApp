package com.app.pizza.Infrastructure.PersistanceModels;

import java.time.LocalDate;

public abstract class UserModel {
    private long id;
    private String fullName;
    private String email;
    private String password;
    private int age;
    private String phoneNumber;
    private LocalDate registrationDate;

    public UserModel(long id, String fullName, String email, String password, int age, String phoneNumber, LocalDate registrationDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    public UserModel(String fullName, String email, String password, int age, String phoneNumber, LocalDate registrationDate) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
