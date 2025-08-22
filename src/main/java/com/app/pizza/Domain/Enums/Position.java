package com.app.pizza.Domain.Enums;

public enum Position {
    KITCHEN, COUNTER_STAFF, MANAGER
}
/*
Примерно ->

If I have threads to open the program on a few threads for every
participant the flow wil be like -> Customer Orders, COUNTER_STAFF receives it and sends it to kitchen,
there is being cooked and when it is ready only KITCHEN can change the order status from
being cooked to ready. Then the Delivery can look what orders are 'ready' and accept it, done via
the Chain of responsibility pattern maybe (дето се праща един и ако я откаже се праща на друг )


*/