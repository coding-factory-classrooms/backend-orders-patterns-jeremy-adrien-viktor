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

    private List<Dish> dish;

    public void setDishes(List<Dish> dish) {
        this.dish = dish;
    }

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Dish> getDish() {
        return dish;
    }
}
