package org.example;

import org.example.models.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersOriginator {

    public Memento save(List<Order> orderList) {
        return new Memento(orderList);
    }

    public List<Order> getAtState(Memento memento) {
        return memento.getOrderList();
    }

    class Memento {
        private List<Order> orderList;

        public List<Order> getOrderList() {
            return this.Kage_Bunshin_no_Jutsu(orderList);
        }

        @Override
        public String toString() {
            return "Memento{" +
                    "orderList=" + orderList +
                    '}';
        }

        public Memento(List<Order> orderList) {
            this.orderList = this.Kage_Bunshin_no_Jutsu(orderList);
        }

        private List<Order> Kage_Bunshin_no_Jutsu(List<Order> orderList) {
            ArrayList<Order> objects = new ArrayList<>();
            for (Order o : orderList) {
                Order order = new Order();
                order.setDishes(o.getDish());
                order.setDateOrder(o.getDateOrder());
                order.setTotalPrice(o.getTotalPrice());
                order.setState(o.getState());
                objects.add(order);
            }
            return objects;
        }
    }
}
