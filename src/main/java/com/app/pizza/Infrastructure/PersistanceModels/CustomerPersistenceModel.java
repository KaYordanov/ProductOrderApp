package com.app.pizza.Infrastructure.PersistanceModels;

import com.app.pizza.Domain.Enums.UserType;

import java.time.LocalDate;

public class CustomerPersistenceModel extends UserPersistenceModel{
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Integer age;
    private String phoneNumber;
    private UserType user_type;
    private LocalDate registrationDate;
    private String address;
    public CustomerPersistenceModel(Long id, String fullName, String email, String password, Integer age, String phoneNumber, String user_type, LocalDate registrationDate, String address) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.user_type = UserType.valueOf(user_type);
        this.registrationDate = registrationDate;
        this.address = address;
    }

    public CustomerPersistenceModel(String fullName, String email, String password, Integer age, String phoneNumber, String user_type, LocalDate registrationDate, String address) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.user_type = UserType.valueOf(user_type);
        this.registrationDate = registrationDate;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setAge(Integer age) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }

}
