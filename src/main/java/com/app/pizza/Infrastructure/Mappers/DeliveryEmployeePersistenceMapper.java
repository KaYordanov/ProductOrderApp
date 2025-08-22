package com.app.pizza.Infrastructure.Mappers;

import com.app.pizza.Domain.Models.DeliveryEmployee;
import com.app.pizza.Infrastructure.PersistanceModels.DeliveryEmployeePersistenceModel;

import java.util.Map;

public class DeliveryEmployeePersistenceMapper implements UserPersistenceMapper<DeliveryEmployee, DeliveryEmployeePersistenceModel>{
    @Override
    public DeliveryEmployee toEntity(DeliveryEmployeePersistenceModel persistenceModel) {
        return new DeliveryEmployee();
    }

    @Override
    public DeliveryEmployeePersistenceModel toPersistenceModel(DeliveryEmployee user) {
        return new DeliveryEmployeePersistenceModel();
    }

    @Override
    public DeliveryEmployeePersistenceModel toPersistenceModel(Map<String, Object> userData) {
        return new DeliveryEmployeePersistenceModel();
    }
}
