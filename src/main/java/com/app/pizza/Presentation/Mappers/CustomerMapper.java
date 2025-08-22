package com.app.pizza.Presentation.Mappers;

import com.app.pizza.Domain.Models.Customer;
import com.app.pizza.Presentation.DTOs.CustomerSignInResponse;
import com.app.pizza.Presentation.DTOs.CustomerSignUpRequest;
import com.app.pizza.Presentation.DTOs.UserSignUpResponse;
import com.app.pizza.Presentation.Mappers.UserMapper;

public class CustomerMapper implements UserMapper<Customer, CustomerSignUpRequest, CustomerSignInResponse> {
    @Override
    public Customer toEntity(CustomerSignUpRequest request) {
        return new Customer();
    }

    @Override
    public UserSignUpResponse toSignUpResponseDTO(Customer entity) {
        return null;
    }

    @Override
    public CustomerSignInResponse toSignInResponseDTO(Customer entity) { // ???? not Customer, User
        return new CustomerSignInResponse();
    }
}
