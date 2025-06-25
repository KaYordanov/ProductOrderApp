package com.app.pizza.Infrastructure.Repositories;

import com.app.pizza.Application.RepositoriesInterfaces.MySqlOrderRepository;
import com.app.pizza.Domain.Models.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepository implements MySqlOrderRepository, DbConnection {

    @Override
    public void saveOrderToDb(Order order) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()
        ){
            // only create the address
            // but what do I do with customerID, do I pass a Customer object?, I
            // need some validations ot get here like only customers can
            // order(if the role is customer, this means that this method should
            // be accessed through log in)

        }catch (SQLException e){
            e.printStackTrace(); // somme connection error
        }
    }

    @Override
    public void retrieveOrderByID(int id) {

    }
}
