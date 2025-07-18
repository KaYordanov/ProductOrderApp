package com.app.pizza.Infrastructure.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public interface DbConnection {
    String url = "jdbc:mysql://localhost:3306/pizzadb";
    String user = "root";
    String password = "123";
}
