package org.example;

import org.example.models.Dish;
import org.example.models.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersSystem {

    private final List<Order> orderList;

    private List<OrdersOriginator.Memento> history;
    private OrdersOriginator ordersOriginator;

    public List<OrdersOriginator.Memento> getHistory() {
        return history;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void createOrderAndReturn(List<Dish> dishes) {
        float sum = 0;
        for (int i = 0; i < dishes.size(); i++)
            sum += dishes.get(i).getPrice();

        Order order = new Order();
        order.setDishes(dishes);
        order.setDateOrder(new Date());
        order.setTotalPrice(sum);
        order.setState(Order.State.NEW);
        orderList.add(order);

        history.add(this.ordersOriginator.save(orderList));
    }

    public OrdersSystem() {
        this.orderList = new ArrayList<>();
        this.history = new ArrayList<>();
        this.ordersOriginator = new OrdersOriginator();
    }

    public Order getOrder(int index) {
        return orderList.get(index);
    }
}
