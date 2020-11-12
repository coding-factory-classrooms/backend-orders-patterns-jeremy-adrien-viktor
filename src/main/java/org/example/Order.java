package org.example;

import org.example.models.Dish;

import java.nio.file.FileStore;
import java.util.List;

public class Order {

    public enum State{
        NEW,
        IN_PROGRESS,
        DONE,
        CANCEL,
    }

    private List<Dish> dishList;
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public boolean addOrder(Dish dish){
        this.state = State.NEW;
        return this.dishList.add(dish);
    }
}
