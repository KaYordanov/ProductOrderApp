package com.app.pizza.Domain.Models;

import com.app.pizza.Domain.Enums.UserType;

import java.time.LocalDate;

public abstract class User {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Integer age;
    private String phoneNumber;
    private UserType userType;
    private LocalDate registrationDate;

    public User(String fullName, String email, String password, Integer age, String phoneNumber, UserType userType) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.registrationDate = LocalDate.now();
        this.userType = userType;
    }

    public User(Long id, String fullName, String email, String password, Integer age, String phoneNumber, LocalDate registrationDate, UserType userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.userType = userType;
    }

    public Long getId() {
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

    public Integer getAge() {
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
