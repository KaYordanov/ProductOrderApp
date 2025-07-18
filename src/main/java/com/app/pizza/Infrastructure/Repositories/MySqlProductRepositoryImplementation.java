package com.app.pizza.Infrastructure.Repositories;

import com.app.pizza.Application.RepositoryInterfaces.MySqlProductRepository;
import com.app.pizza.Domain.Models.Product;
import com.app.pizza.Infrastructure.DataSource.DbConnection;

import java.sql.*;

public class MySqlProductRepositoryImplementation implements MySqlProductRepository, DbConnection {
    @Override
    public Product getPizzaByName(String pizzaName) {

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pizzas WHERE name = ?")
        ){
            stmt.setString(1, pizzaName);

            ResultSet rs = stmt.executeQuery();






        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
