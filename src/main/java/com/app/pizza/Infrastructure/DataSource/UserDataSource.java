package com.app.pizza.Infrastructure.DataSource;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDataSource implements MySqlUserDataSource, DbConnection{

    // log in

    @Override
    public Long validateUser(String email, String pass) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // check if email exists
            String emailQuery = "SELECT id, password FROM user WHERE email = ?";
            try (PreparedStatement ps = conn.prepareStatement(emailQuery)) {
                ps.setString(1, email);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        throw EmailNotFoundExceptoin;
                    }

                    String storedPassword = rs.getString("password");

                    // validate password
                    if (storedPassword.equals(pass)) {
                        return rs.getLong("id");
                    } else {
                        throw WrongPasswordException;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // handle exception as needed
            // learn about exceptions, custom exceptions, where to handle and throw, and if in catch I should have anything here
            return null;
        }
    }

    @Override
    public Map<String, Object> findById(long id) {
        Map<String, Object> userMap = new LinkedHashMap<>();
    }










    @Override
    public Map<String, Map<String, Object>> getUserData(String email, String pass) {
        Map<String, Map<String, Object>> finalMap = new LinkedHashMap<>();
        String userType;
        Map<String, Object> userMap = new LinkedHashMap<>();

        if(!checkEmail(email) || checkPassword(pass)){
            throw // some kind of no arguments or values found exception in the two methods so that I can differentiate what is wrong of the two
        }

        try (final var connection = DriverManager.getConnection(url, user, password);
             PreparedStatement userCheckStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
             PreparedStatement employeeCheckStatement = connection.prepareStatement("SELECT * FROM employee WHERE user_id = ?")

        ){
            userCheckStatement.setString(1, email);
            userCheckStatement.setString(2, pass);

            ResultSet userRS = userCheckStatement.executeQuery();
            userMap.putAll(toMap(userRS));
            Long id = userRS.getLong("id");
            userType = userRS.getString("user_type");

            if (userType.equals("Customer")){
                userMap.putAll(tableSearch(connection, "customer", "user_id", id));
            } else {
                employeeCheckStatement.setLong(1, id);
                ResultSet employeeRS = employeeCheckStatement.executeQuery();
                userMap.putAll(toMap(employeeRS));
                Long employeeId = userRS.getLong("employee_id");

                if (userType.equals("DELIVERY")) {
                    userMap.putAll(tableSearch(connection, "delivery_employee", "employee_id", employeeId));
                } else if (userType.equals("ON_SITE")) {
                    userMap.putAll(tableSearch(connection, "delivery_employee", "employee_id", employeeId));
                } else {
                    // some exception
                }
            }

            finalMap.put(userType, userMap);
            return finalMap;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> tableSearch(Connection connection, String table, String column, Long id) throws SQLException{
        Map<String, Object> data;
        String query = "SELECT * FROM " + table + " WHERE " + column + " = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            data = toMap(rs);
        }

        return data;
    }

    private Map<String, Object> toMap(ResultSet rs) throws SQLException{
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
        }
    }
}
