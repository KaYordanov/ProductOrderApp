package com.app.pizza.Infrastructure.Mappers;

import com.app.pizza.Domain.Abstractions.User;
import com.app.pizza.Domain.Models.Customer;
import com.app.pizza.Domain.Models.DeliveryEmployee;
import com.app.pizza.Domain.Models.OnSiteEmployee;
import com.app.pizza.Infrastructure.PersistanceModels.CustomerModel;
import com.app.pizza.Infrastructure.PersistanceModels.DeliveryEmployeeModel;
import com.app.pizza.Infrastructure.PersistanceModels.OnSiteEmployeeModel;

public class UserMapper implements UserDataMapper{
    @Override
    public User toEntity(CustomerModel customerModel){
        return new Customer(customerModel.getId(), customerModel.getFullName(),  customerModel.getEmail(),  customerModel.getPassword(),  customerModel.getAge(),  customerModel.getPhoneNumber(), customerModel.getRegistrationDate(), customerModel.getAddress());
    }
    @Override
    public User toEntity(DeliveryEmployeeModel customerDTO){
        return new DeliveryEmployee();
    }

    @Override
    public User toEntity(OnSiteEmployeeModel customerDTO){
        return new OnSiteEmployee();
    }


    @Override
    public CustomerModel toDto(Customer customerEntity){
        return new CustomerModel();
    }
    @Override
    public OnSiteEmployeeModel toDto(OnSiteEmployee onSiteEmployeeEntity){
        return new OnSiteEmployeeModel();
    }
    @Override
    public DeliveryEmployeeModel toDto(DeliveryEmployee deliveryEmployeeEntity){
        return new DeliveryEmployeeModel();
    }

}
