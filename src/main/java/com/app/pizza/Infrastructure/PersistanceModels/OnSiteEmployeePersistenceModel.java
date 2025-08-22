package com.app.pizza.Infrastructure.PersistanceModels;

import com.app.pizza.Domain.Enums.Position;
import com.app.pizza.Domain.Enums.UserType;

import java.time.LocalDate;

public class OnSiteEmployeePersistenceModel extends UserPersistenceModel{
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Integer age;
    private UserType user_type;
    private String phoneNumber;
    private LocalDate registrationDate;
    private Double salary;
    private LocalDate hireDate;
    private Position position;

    public OnSiteEmployeePersistenceModel(Long id, String fullName, String email, String password, Integer age, UserType user_type, String phoneNumber, LocalDate registrationDate, Double salary, LocalDate hireDate, Position position) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.user_type = user_type;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.salary = salary;
        this.hireDate = hireDate;
        this.position = position;
    }

    public OnSiteEmployeePersistenceModel(String fullName, String email, String password, Integer age, UserType user_type, String phoneNumber, LocalDate registrationDate, Double salary, LocalDate hireDate, Position position) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.user_type = user_type;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.salary = salary;
        this.hireDate = hireDate;
        this.position = position;
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

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
