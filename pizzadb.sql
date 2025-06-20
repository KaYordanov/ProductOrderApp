CREATE DATABASE pizzadb;
USE pizzadb;

CREATE TABLE employees (
    employeeID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT NOT NULL,
    phoneNumber VARCHAR(15) UNIQUE NOT NULL,
	position ENUM('Manager', 'Delivery', 'On-site') NOT NULL
);

CREATE TABLE customers (
    customerID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT NOT NULL,
    phoneNumber VARCHAR(15) UNIQUE NOT NULL
);

CREATE TABLE orders (
    orderID INT AUTO_INCREMENT PRIMARY KEY,
    orderDate DATETIME NOT NULL,
    address VARCHAR(255) NOT NULL,
	position ENUM('', '', '') NOT NULL,
    customerID INT NOT NULL,
	FOREIGN KEY (customerID) REFERENCES customers(customerID) ON DELETE CASCADE
);

CREATE TABLE pizzas (
    pizzaID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL
);

CREATE TABLE order_pizzas (
    orderID INT NOT NULL,
    pizzaID INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    CONSTRAINT FOREIGN KEY (orderID) REFERENCES orders(orderID) ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (pizzaID) REFERENCES pizzas(pizzaID) ON DELETE CASCADE
);

-- drop all tables when you starrt working on the project !!!!!!!!!


