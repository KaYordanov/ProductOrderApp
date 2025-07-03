CREATE DATABASE pizzadb;
USE pizzadb;

CREATE TABLE user (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    age INT,
    phone_number VARCHAR(20),
    registration_date DATE NOT NULL
);

CREATE TABLE customer (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    address VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user(id)
);


CREATE TABLE employee (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    salary DECIMAL(10, 2),
    hire_date DATE,
    user_id BIGINT PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE delivery_employee (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT  NOT NULL,
    vehicle_type VARCHAR(50),
    vehicle_brand VARCHAR(50),
    license_plate VARCHAR(20),
    is_company_vehicle BOOLEAN,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE onsite_employee (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT  NOT NULL,
    position ENUM('KITCHEN', 'COUNTER_STAFF', 'MANAGER'),
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE `order` (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    delivery_employee_id BIGINT,
    delivery_type ENUM('PICKUP', 'DELIVERY') NOT NULL,
    order_date DATETIME NOT NULL,
    order_update DATETIME,
    address VARCHAR(255) NOT NULL,
    order_status ENUM('PENDING','CONFIRMED', 'IN_PREPARATION', 'READY_FOR_PICKUP', 'OUT_FOR_DELIVERY', 'DELIVERED', 'CANCELLED') NOT NULL DEFAULT 'PENDING',
    total_sum DECIMAL(10, 2) NOT NULL,
    notes TEXT,
    discounted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (delivery_employee_id) REFERENCES employee(id)
);

CREATE TABLE item (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT NOT NULL,
    size ENUM('SMAILL', 'MEDIUM', 'LARGE') NOT NULL
);


CREATE TABLE order_item (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    PRIMARY KEY (order_id, item_id),
    FOREIGN KEY (order_id) REFERENCES `order`(id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE
);
