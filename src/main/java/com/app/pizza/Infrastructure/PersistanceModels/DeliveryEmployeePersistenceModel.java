package com.app.pizza.Infrastructure.PersistanceModels;

import com.app.pizza.Domain.Enums.UserType;

import java.time.LocalDate;

public class DeliveryEmployeePersistenceModel extends UserPersistenceModel{
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Integer age;
    private String phoneNumber;
    private UserType user_type;
    private LocalDate registrationDate;
    private Double salary;
    private LocalDate hire_date;
    private String vehicleType;
    private String vehicleBrand;
    private String licensePlate;
    private boolean companyVehicle;

    public DeliveryEmployeePersistenceModel(Long id, String fullName, String email, String password, Integer age, String phoneNumber, UserType user_type, LocalDate registrationDate, Double salary, LocalDate hire_date, String vehicleType, String vehicleBrand, String licensePlate, boolean companyVehicle) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.user_type = user_type;
        this.registrationDate = registrationDate;
        this.salary = salary;
        this.hire_date = hire_date;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.licensePlate = licensePlate;
        this.companyVehicle = companyVehicle;
    }

    public DeliveryEmployeePersistenceModel(String fullName, String email, String password, Integer age, String phoneNumber, UserType user_type, LocalDate registrationDate, Double salary, LocalDate hire_date, String vehicleType, String vehicleBrand, String licensePlate, boolean companyVehicle) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.user_type = user_type;
        this.registrationDate = registrationDate;
        this.salary = salary;
        this.hire_date = hire_date;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.licensePlate = licensePlate;
        this.companyVehicle = companyVehicle;
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

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
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

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isCompanyVehicle() {
        return companyVehicle;
    }

    public void setCompanyVehicle(boolean companyVehicle) {
        this.companyVehicle = companyVehicle;
    }
}