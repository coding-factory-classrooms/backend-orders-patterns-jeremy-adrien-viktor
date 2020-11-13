package org.example.models;

import java.util.Date;
import java.util.List;

public class Order {

    public enum State{
        NEW,
        IN_PROGRESS,
        DONE,
        CANCEL,
    }

    @Override
    public String toString() {
        return "Order{" +
                "totalPrice=" + totalPrice +
                ", dateOrder=" + dateOrder +
                ", dish=" + dish +
                ", state=" + state +
                '}';
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
        setDateOrder(new Date());
        if (stateChangedListener != null) {
            stateChangedListener.onSateChanged(this);
        }
    }

    public List<Dish> getDish() {
        return dish;
    }

    public interface OnStateChangedListener {
        void onSateChanged(Order order);
    }
    private OnStateChangedListener stateChangedListener;

    public void setStateChangedListener(OnStateChangedListener listener) {
        stateChangedListener = listener;
    }
}
