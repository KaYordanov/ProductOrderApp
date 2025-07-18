package com.app.pizza.Infrastructure.Mappers;

import com.app.pizza.Domain.Abstractions.User;
import com.app.pizza.Domain.Models.Customer;
import com.app.pizza.Domain.Models.DeliveryEmployee;
import com.app.pizza.Domain.Models.OnSiteEmployee;
import com.app.pizza.Infrastructure.PersistanceModels.CustomerModel;
import com.app.pizza.Infrastructure.PersistanceModels.DeliveryEmployeeModel;
import com.app.pizza.Infrastructure.PersistanceModels.OnSiteEmployeeModel;
import com.app.pizza.Infrastructure.PersistanceModels.UserModel;

public interface UserDataMapper {

    User toEntity(CustomerModel customerModel);
    User toEntity(DeliveryEmployeeModel customerDTO);
    User toEntity(OnSiteEmployeeModel customerDTO);

    CustomerModel toDto(Customer customerEntity);
    OnSiteEmployeeModel toDto(OnSiteEmployee onSiteEmployeeEntity);
    DeliveryEmployeeModel toDto(DeliveryEmployee deliveryEmployeeEntity);
}
