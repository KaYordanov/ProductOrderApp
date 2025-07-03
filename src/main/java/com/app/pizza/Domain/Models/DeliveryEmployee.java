package com.app.pizza.Domain.Models;

import java.time.LocalDate;

public class DeliveryEmployee extends Employee{
    private String vehicleType;
    private String vehicleBrand;
    private String licensePlate;
    private boolean isCompanyVehicle;

    public DeliveryEmployee(String fullName, String email, String password, int age, String phoneNumber, double salary, LocalDate hireDate, String vehicleType, String vehicleBrand, String licensePlate, boolean isCompanyVehicle) {
        super(fullName, email, password, age, phoneNumber, salary, hireDate);
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.licensePlate = licensePlate;
        this.isCompanyVehicle = isCompanyVehicle;
    }

    public DeliveryEmployee(long id, String fullName, String email, String password, int age, String phoneNumber, LocalDate registrationDate, double salary, LocalDate hireDate, String vehicleType, String vehicleBrand, String licensePlate, boolean isCompanyVehicle) {
        super(id, fullName, email, password, age, phoneNumber, registrationDate, salary, hireDate);
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.licensePlate = licensePlate;
        this.isCompanyVehicle = isCompanyVehicle;
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
        return isCompanyVehicle;
    }

    public void setCompanyVehicle(boolean companyVehicle) {
        isCompanyVehicle = companyVehicle;
    }
}
