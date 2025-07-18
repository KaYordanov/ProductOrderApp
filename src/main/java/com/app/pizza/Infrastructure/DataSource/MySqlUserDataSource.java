package com.app.pizza.Infrastructure.DataSource;

import java.util.Map;

public interface MySqlUserDataSource {
    boolean validateEmail(String email);
    Long validateUser(String email, String pass);
    Map<String, Object> findById(long id);

}
