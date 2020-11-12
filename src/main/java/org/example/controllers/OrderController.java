package org.example.controllers;

import org.example.Order;
import org.example.OrdersSystem;
import org.example.core.Template;
import org.example.models.Dish;
import org.example.models.Ingredient;
import org.example.models.Panini;
import org.example.models.Pizza;
import org.example.utils.URLUtils;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {

    private OrdersSystem orders;
    private final List<Pizza> pizzaList;
    private final List<Panini> paniniList;

    public OrderController(OrdersSystem orders, List<Pizza> pizzaList, List<Panini> paniniList) {
        this.orders = orders;
        this.pizzaList = pizzaList;
        this.paniniList = paniniList;
    }

//    public String orderDetail(Request req, Response res){
//        Map<String, Object> model = new HashMap<>();
//        return Template.render("clientOrder.html",model);
//    }

    public Object orderCreate(Request req, Response res) {
        Map<String, String> reqBody = URLUtils.decodeQuery(req.body());

        List<Dish> dishes = new ArrayList<>();
        if (!reqBody.get("pizza").isEmpty()) {
            Pizza selectedPizza = pizzaList.get(Integer.parseInt(reqBody.get("pizza")));
            dishes.add(selectedPizza);
        }
        if (!reqBody.get("panini").isEmpty()) {
            Panini selectedPanini = paniniList.get(Integer.parseInt(reqBody.get("panini")));
            dishes.add(selectedPanini);
        }
        Order o = orders.createOrderAndReturn(dishes);
        Map<String, Object> model = new HashMap<>();
        model.put("order", o);
        return Template.render("clientOrder.html", model);
    }
}



