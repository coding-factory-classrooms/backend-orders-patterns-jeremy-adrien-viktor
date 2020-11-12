package org.example;

import org.example.models.Dish;

import java.util.Date;
import java.util.List;

public class Order {

    public enum State{
        NEW,
        IN_PROGRESS,
        DONE,
        CANCEL,
    }

    private float totalPrice;

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalePrice) {
        this.totalPrice = totalePrice;
    }

    private Date dateOrder;

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
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

    public boolean isInThisState(State state){
        System.out.println("state");
        if (getState() == state){
            return true;
        }
        return false;
    }
}
