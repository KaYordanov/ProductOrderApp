package com.app.pizza.Infrastructure.Repositories;

import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Domain.Abstractions.User;
import com.app.pizza.Infrastructure.PersistanceModels.CustomerModel;
import com.app.pizza.Infrastructure.PersistanceModels.DeliveryEmployeeModel;
import com.app.pizza.Infrastructure.PersistanceModels.OnSiteEmployeeModel;
import com.app.pizza.Infrastructure.PersistanceModels.UserModel;
import com.app.pizza.Infrastructure.DataSource.MySqlUserDataSource;
import com.app.pizza.Infrastructure.Mappers.UserDataMapper;

import java.util.Map;

public class MySqlUserRepositoryImplementation implements MySqlUserRepository {
    MySqlUserDataSource userDataSource;
    UserDataMapper userMapper;

    // constructor

    @Override
    public User createNewUser(User user) {
        userDataSource.persist(userMapper.toDto(user));

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public void updateUser(long id) {

    }

    @Override
    public User getUser(String email, String password){
        Long userId = userDataSource.validateUser(email, password);

        if(userId.equals(null)){
            throw // something;
        }

        Map<String, Object> userDetails = userDataSource.findById(userId);
        String userType = (String) userDetails.get("user_type");

        switch (userType) {
            case "CUSTOMER" -> {
                userDetails.putAll(userDataSource.loadCustomer(userId)); // make the methods and queries
                CustomerModel userDTO = buildCustomerModel(userDetails);

                return userMapper.toEntity(userDTO); // make UserDTO an interface and make the others implement it
            }
            case "DELIVERY" -> {
                userDetails.putAll(userDataSource.loadDeliveryEmployee(userId));
                DeliveryEmployeeModel userDTO = buildDeliveryEmployeeModel(userDetails);

                return userMapper.toEntity(userDTO);
            }
            case "ON_SITE" -> {
                userDetails.putAll(userDataSource.loadOnsiteEmployee(userId));
                OnSiteEmployeeModel userDTO = buildOnSiteEmployeeModel(userDetails);

                return userMapper.toEntity(userDTO);
            }
        }
    }

    private OnSiteEmployeeModel buildOnSiteEmployeeModel(Map<String, Object> userDetails) {
        return new OnSiteEmployeeModel();  // finish the DTOs
    }

    private DeliveryEmployeeModel buildDeliveryEmployeeModel(Map<String, Object> userDetails) {
        return new DeliveryEmployeeModel();
    }

    private CustomerModel buildCustomerModel(Map<String, Object> userDetails) {
        return new CustomerModel();
    }









    private UserModel buildDTO(String userType, Map<String, Object> map) {
        switch (userType) {
            case "CUSTOMER" -> {
                return new CustomerModel(
                        (Long) map.get("id"),
                        (String) map.get("full_name"),
                        (String) map.get("email"),
                        (String) map.get("password"),
                        (Integer) map.get("age"),
                        (String) map.get("phone_number"),
                        (DateTime) map.get("registration_date"),
                        (String) map.get("address")
                );
            }
            case "DELIVERY" -> {
                return new DeliveryEmployeeModel(
                ... // populate from map
                );
            }
            case "ON_SITE" -> {
                return new OnSiteEmployeeModel(
                ... // populate from map
                );
            }
            default -> throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}
