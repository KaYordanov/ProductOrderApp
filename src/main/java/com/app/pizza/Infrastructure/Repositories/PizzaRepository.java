package com.app.pizza.Infrastructure.Repositories;

import com.app.pizza.Application.RepositoriesInterfaces.IPizzaRepository;
import com.app.pizza.Domain.Models.Pizza;

import java.sql.*;

public class PizzaRepository implements IPizzaRepository, DbConnection {
    @Override
    public Pizza getPizzaByName(String pizzaName) {

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pizzas WHERE name = ?")
        ){
            stmt.setString(1, pizzaName);

            ResultSet rs = stmt.executeQuery();






        }catch (Exception e){
            e.printStackTrace();
        }
        return null; //  !!!!!!!!!!!!!!!!!  trqbva da se maxne kato go izmislq !!!!!!!!!!!!!!!
    }
}
