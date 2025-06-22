CREATE DATABASE pizzadb;
USE pizzadb;

CREATE TABLE employees (
    employeeID BIGINT  AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT NOT NULL,
    phoneNumber VARCHAR(15) UNIQUE NOT NULL,
	position ENUM('Manager', 'Delivery', 'On-site') NOT NULL
);

CREATE TABLE customers (
    customerID BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT NOT NULL,
    phoneNumber VARCHAR(15) UNIQUE NOT NULL
);

CREATE TABLE orders (
    orderID BIGINT AUTO_INCREMENT PRIMARY KEY,
    orderDate DATETIME NOT NULL,
    address VARCHAR(255) NOT NULL,
	position ENUM('', '', '') NOT NULL,
    customerID BIGINT NOT NULL,
	FOREIGN KEY (customerID) REFERENCES customers(customerID) ON DELETE CASCADE
);

CREATE TABLE pizzas (
    pizzaID BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL
);




-- above tables are not final !!!!!!!!!


CREATE TABLE users (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    age INT,
    phone_number VARCHAR(20),
    registration_date DATE NOT NULL
);

CREATE TABLE customers (
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100),
    zip_code VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE employees (
	employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    salary DECIMAL(10, 2),
    hire_date DATE,
    user_id BIGINT PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE delivery_employees (
    delivery_id BIGINT  AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT  NOT NULL,
    vehicle_type VARCHAR(50),
    vehicle_brand VARCHAR(50),
    license_plate VARCHAR(20),
    is_company_vehicle BOOLEAN,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE
);

CREATE TABLE onsite_employees (
    onsite_id BIGINT  AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT  NOT NULL,
    position ENUM('KITCHEN', 'COUNTER_STAFF', 'MANAGER'),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE
);

CREATE TABLE orders (
    order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    delivery_employee_id BIGINT,  -- can be NULL if order is not delivered by employee (e.g. pickup)
    customer_name VARCHAR(255) NOT NULL,
    order_date DATE NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    order_status ENUM('PENDING','CONFIRMED', 'IN_PREPARATION', 'READY_FOR_PICKUP', 'OUT_FOR_DELIVERY', 'DELIVERED') NOT NULL DEFAULT 'PENDING',
    total_sum DECIMAL(10, 2) NOT NULL,
    notes TEXT,
    discounted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (delivery_employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE order_pizzas (
    order_id BIGINT NOT NULL,
    pizza_id BIGINT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    PRIMARY KEY (order_id, pizza_id),
    CONSTRAINT FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (pizza_id) REFERENCES pizzas(pizza_id) ON DELETE CASCADE
);
