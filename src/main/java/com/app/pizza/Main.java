package com.app.pizza;

import com.app.pizza.Application.RepositoryInterfaces.MySqlOrderRepository;
import com.app.pizza.Application.RepositoryInterfaces.MySqlProductRepository;
import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Application.UseCases.user.Implementations.RegisterUserUseCase;
import com.app.pizza.Application.UseCases.user.Implementations.DeleteUserUseCase;
import com.app.pizza.Application.UseCases.user.Implementations.RetrieveUserUseCase;
import com.app.pizza.Application.UseCases.user.Implementations.UpdateUserUseCase;
import com.app.pizza.Application.UseCases.user.Interfaces.RegisterUser;
import com.app.pizza.Application.UseCases.user.Interfaces.DeleteUser;
import com.app.pizza.Application.UseCases.user.Interfaces.RetrieveUser;
import com.app.pizza.Application.UseCases.user.Interfaces.UpdateUser;
import com.app.pizza.Infrastructure.Repositories.MySqlOrderRepositoryImplementation;
import com.app.pizza.Infrastructure.Repositories.MySqlProductRepositoryImplementation;
import com.app.pizza.Infrastructure.Repositories.MySqlUserRepositoryImplementation;
import com.app.pizza.Presentation.Controllers.*;
import com.app.pizza.Presentation.DTOs.UserSignUpRequest;
import com.app.pizza.Presentation.DTOs.UserSignUpResponse;
import com.app.pizza.Presentation.Mappers.UserMapper;
import com.app.pizza.Presentation.Mappers.UserMapperImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();

        UserMapper userMapper = new UserMapperImplementation();

        MySqlUserRepository mySqlUserRepository = new MySqlUserRepositoryImplementation();
        MySqlOrderRepository mySqlOrderRepository = new MySqlOrderRepositoryImplementation();
        MySqlProductRepository mySqlProductRepository = new MySqlProductRepositoryImplementation();

        RegisterUser registerUser = new RegisterUserUseCase(mySqlUserRepository);
        RetrieveUser retrieveUser = new RetrieveUserUseCase();
        UpdateUser updateUser = new UpdateUserUseCase();
        DeleteUser deleteUser = new DeleteUserUseCase();

        UserController customerController = new UserControllerImplementation(registerUser, retrieveUser, updateUser, deleteUser, userMapper);
        // OrderController orderController = new OrderControllerImplementation();
        // ProductController productController = new ProductControllerImplementation();




        // customer register process

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("=== Customer Registration ===");

            System.out.print("Enter full name: ");
            String fullName = reader.readLine();        // finish separation -> ' '

            System.out.print("Enter email: ");
            String email = reader.readLine();

            System.out.print("Enter password: ");
            String password = reader.readLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Enter phone number: ");
            String phoneNumber = reader.readLine();

            System.out.print("Enter address: ");
            String address = reader.readLine();         // finish separation -> ' '


            String jsonRegistrationRequest = String.format(
                "{" + "\"fullName\": \"%s\", " +
                    "\"email\": \"%s\", " +
                    "\"password\": \"%s\", " +
                    "\"age\": %d, " +
                    "\"phoneNumber\": \"%s\", " +
                    "\"address\": \"%s\"" +
                "}", fullName, email, password, age, phoneNumber, address
            );

            UserSignUpRequest userSignUpRequest = objectMapper.readValue(jsonRegistrationRequest, UserSignUpRequest.class);
            UserSignUpResponse userSignUpResponse = customerController.signUp(userSignUpRequest);
            String jsonUserRegistrationResponse = objectMapper.writeValueAsString(userSignUpResponse);

            // check how and what to return to Main for the different situation (like HTTPS status, JSON body, error (exception))




        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

/*
1.
2. On-site COUNTER_STAFF employee can check PENDING orders and mark it as CONFIRMED
3. KITCHEN can check CONFIRMED orders and mark it as IN_PREPARATION and when ready,
   mark it as READY_FOR_PICKUP
4. Delivery employee can check READY_FOR_PICKUP orders and mark one or many as
   OUT_FOR_DELIVERY and after some time as DELIVERED
 */


/*
Order modification plan


1. User is able to make changes to his order only if it is in PENDING status
2. User is presented with the modification options (the order type, address, city, zip code, notes and somehow the pizza choices maybe)
3. User chooses an order
4. We have a Map<String, Object> with the field name and the new value as Object because it may contain different type of data, more generic
5. Then we do the while() loop for the choices and a switch-case for the inputted field in which we add to the Map
6. Then we do and if-else checking if the Map is empty
7. If it is not we call the Controller->Service->Repository passing the 'id' of the Order and the Map
8. Figuring out what to do in terms of Service and Repository - in Services some company validation and
9. In Repository we crate the query with StringBuilder and we append the different parts like col names, values and the order id


Scanner scanner = new Scanner(System.in); // Use reader instead of Scanner

// Step 1: List PENDING orders
List<Order> pendingOrders = orderService.getPendingOrdersForCustomer(customerId);
for (Order order : pendingOrders) {
    System.out.println("Order ID: " + order.getOrderID() + " | Status: " + order.getOrderStatus());
}

// Step 2: Ask which order to modify
System.out.print("Enter Order ID to modify: ");
long orderId = Long.parseLong(scanner.nextLine());



Map<String, Object> updates = new HashMap<>();

boolean done = false;

while (!done) {
    System.out.println("Which field would you like to update?");
    System.out.println("1. Order Type");
    System.out.println("2. Address");
    System.out.println("3. City");
    System.out.println("4. Zip Code");
    System.out.println("5. Notes");
    System.out.println("6. Done");

    System.out.print("Your choice: ");
    String choice = scanner.nextLine();

    switch (choice) {
        case "1":
            System.out.print("Enter new Order Type (DELIVERY / PICKUP): ");
            String typeInput = scanner.nextLine().trim().toUpperCase();
            updates.put("order_type", typeInput);
            break;
        case "2":
            System.out.print("Enter new Address: ");
            updates.put("address", scanner.nextLine());
            break;
        case "3":
            System.out.print("Enter new City: ");
            updates.put("city", scanner.nextLine());
            break;
        case "4":
            System.out.print("Enter new Zip Code: ");
            updates.put("zip_code", scanner.nextLine());
            break;
        case "5":
            System.out.print("Enter new Notes: ");
            updates.put("notes", scanner.nextLine());
            break;
        case "6":
            done = true;
            break;
        default:
            System.out.println("Invalid option.");
            break;
    }
}



if (!updates.isEmpty()) {
    orderService.updateOrder(orderId, updates);
    System.out.println("Order updated.");
} else {
    System.out.println("No changes made.");
}



public void updateOrder(long orderId, Map<String, Object> updates) {
    StringBuilder sql = new StringBuilder("UPDATE orders SET ");

    List<String> fields = new ArrayList<>();
    for (String field : updates.keySet()) {
        fields.add(field + " = ?");
    }
    sql.append(String.join(", ", fields));
    sql.append(" WHERE order_id = ?");

    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

        int index = 1;
        for (Object value : updates.values()) {
            stmt.setObject(index++, value);
        }
        stmt.setLong(index, orderId);

        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

 */