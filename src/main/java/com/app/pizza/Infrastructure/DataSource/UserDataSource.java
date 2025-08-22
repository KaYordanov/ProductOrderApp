package com.app.pizza.Infrastructure.DataSource;

import com.app.pizza.Domain.CustomExceptions.UserNotFoundException;
import com.app.pizza.Infrastructure.CustomExceptions.DatabaseAccessException;
import com.app.pizza.Infrastructure.PersistanceModels.UserPersistenceModel;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDataSource implements MySqlUserDataSource, DbConnection{

    // log in

    @Override
    public Long validateEmailAndPassword(String email, String pass){
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement("SELECT id FROM user WHERE email = ? AND password = ?")){

            ps.setString(1, email);
            ps.setString(2, pass);

            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return rs.getLong("user_id");
                } else {
                    throw new UserNotFoundException("User does not exist");
                }
            }

        } catch (SQLException e){
            throw new DatabaseAccessException("Failed to access user data");
            e.printStackTrace();
        }
    }

    @Override
    public <P extends UserPersistenceModel> void persist(P model){

        switch (model.getUserType()){
            case "CUSTOMER" -> ;
            case "DELIVERY" -> ;
            case "ON_SITE" -> ;
            default -> throw new IllegalArgumentException("Unsupported user type");

        }
        // create the queries
    }

    @Override
    public Map<String, Object> findById(Long id) {
        Map<String, Object> userDataMap = new LinkedHashMap<>();
        // изнеси в метод намирането на конкретните юзъри
    }



    @Override
    public Map<String, Object> findByEmailAndPassword(String email, String pass) {
        // this method will go to findById() method (all user searches will be based on id)

        Map<String, Object> finalMap = new LinkedHashMap<>();


        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement userCheckStatement = connection.prepareStatement("SELECT id AS user_id, full_name, email, password, age, phone_number, user_type, registration_date  FROM user WHERE email = ? AND password = ?");
        ){

            try(ResultSet rs = userCheckStatement.executeQuery()){
                if(!rs.next()){
                    throw new UserNotFoundException("User does not exist");

                } else {
                    finalMap.putAll(toMap(rs));
                    Long id = rs.getLong("user_id");

                    switch (rs.getString("user_type")){
                        case "CUSTOMER" -> finalMap.putAll(customerTableSearch(connection, id));
                        case "DELIVERY" -> finalMap.putAll(deliveryEmployeeTableSearch(connection, id));
                        case "ON_SITE" -> finalMap.putAll(onSiteEmployeeTableSearch(connection, id));
                        default -> throw new IllegalArgumentException("Unsupported user type");

                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return finalMap; // tyk li triabva da e return-a
    }

    private Map<String, Object> customerTableSearch(Connection connection, Long id) throws SQLException{
        Map<String, Object> data;

        try (PreparedStatement stmt = connection.prepareStatement("SELECT address FROM customer WHERE user_id = ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                data = toMap(rs);
            }

        }

        return data;
    }

    private Map<String, Object> deliveryEmployeeTableSearch(Connection connection, Long id) throws SQLException{
        Map<String, Object> data;

        try (PreparedStatement stmt = connection.prepareStatement("SELECT salary, hire_date, vehicle_type, vehicle_brand, license_plate, is_company_vehicle  FROM customer WHERE user_id = ?")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                data = toMap(rs);
            }
        }

        return data;
    }

    private Map<String, Object> onSiteEmployeeTableSearch(Connection connection, Long id) throws SQLException{
        Map<String, Object> data;

        try (PreparedStatement stmt = connection.prepareStatement("SELECT salary, hire_date, position FROM customer WHERE user_id = ?")){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                data = toMap(rs);
            }
        }

        return data;
    }

    private Map<String, Object> toMap (ResultSet rs) throws SQLException{
        Map<String, Object> map = new LinkedHashMap<>();

        if(rs.next()){
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);
                Object value = rs.getObject(i);
                map.put(columnName, value);
            }

            return map;
        } else {
            throw // some exception and check whether to catch or throw the exception
        }
    }
}
