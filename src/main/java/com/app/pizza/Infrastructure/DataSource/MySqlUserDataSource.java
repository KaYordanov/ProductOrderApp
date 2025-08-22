package com.app.pizza.Infrastructure.DataSource;

import com.app.pizza.Infrastructure.PersistanceModels.UserPersistenceModel;

import java.sql.SQLException;
import java.util.Map;

public interface MySqlUserDataSource {
    // boolean validateEmail(String email);
    Long validateEmailAndPassword(String email, String pass) throws SQLException; // changed to boolean from Long
    Map<String, Object> findByEmailAndPassword(String email, String password);
    Map<String, Object> findById(Long id);
    void persist(UserPersistenceModel model);
}
