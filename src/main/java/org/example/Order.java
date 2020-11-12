package org.example;

import org.example.models.Dish;

import java.util.List;

public class Order {

    public enum State{
        NEW,
        IN_PROGRESS,
        DONE,
        CANCEL,
    }

    private List<Dish> orderList;
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Dish> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Dish> orderList) {
        this.orderList = orderList;
    }

    public boolean addOrder(Dish dish){
        this.state = State.NEW;
        return this.orderList.add(dish);
    }
}
