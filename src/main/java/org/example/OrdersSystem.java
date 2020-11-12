package org.example;

import org.example.models.Dish;

import java.util.ArrayList;
import java.util.List;

public class OrdersSystem {

    private final List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public Order createOrderAndReturn(List<Dish> dishes) {
        Order order = new Order();
        order.setDishes(dishes);
        order.setState(Order.State.NEW);
        orderList.add(order);
        return orderList.get(orderList.size() -1);
    }

    public OrdersSystem() {
        this.orderList = new ArrayList<>();
    }
}
