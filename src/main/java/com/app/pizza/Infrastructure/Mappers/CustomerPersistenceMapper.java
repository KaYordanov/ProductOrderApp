package com.app.pizza.Infrastructure.Mappers;

import com.app.pizza.Domain.Models.Customer;
import com.app.pizza.Infrastructure.PersistanceModels.CustomerPersistenceModel;

import java.util.Map;

public class CustomerPersistenceMapper implements UserPersistenceMapper<Customer, CustomerPersistenceModel> {
    @Override
    public Customer toEntity(CustomerPersistenceModel persistenceModel) {
        return new Customer();
    }

    @Override
    public CustomerPersistenceModel toPersistenceModel(Customer user) {
        return new CustomerPersistenceModel();
    }

    @Override
    public CustomerPersistenceModel toPersistenceModel(Map<String, Object> userData) {
        return new CustomerPersistenceModel();
    }
}
