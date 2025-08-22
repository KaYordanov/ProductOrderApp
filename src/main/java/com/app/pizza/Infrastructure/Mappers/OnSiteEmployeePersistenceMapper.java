package com.app.pizza.Infrastructure.Mappers;

import com.app.pizza.Domain.Models.OnSiteEmployee;
import com.app.pizza.Infrastructure.PersistanceModels.OnSiteEmployeePersistenceModel;

import java.util.Map;

public class OnSiteEmployeePersistenceMapper implements UserPersistenceMapper<OnSiteEmployee, OnSiteEmployeePersistenceModel> {
    @Override
    public OnSiteEmployee toEntity(OnSiteEmployeePersistenceModel persistenceModel) {
        new OnSiteEmployee();
    }

    @Override
    public OnSiteEmployeePersistenceModel toPersistenceModel(OnSiteEmployee user) {
        return new OnSiteEmployeePersistenceModel();
    }

    @Override
    public OnSiteEmployeePersistenceModel toPersistenceModel(Map<String, Object> userData) {
        return new OnSiteEmployeePersistenceModel();
    }
}
