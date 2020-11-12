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

    public Object orderCreate(Request req, Response res) {
        Map<String, String> reqBody = URLUtils.decodeQuery(req.body());

        List<Dish> dishes = new ArrayList<>();
        if (!reqBody.get("pizza").isEmpty()) {
            Pizza selectedPizza = pizzaList.get(Integer.parseInt(reqBody.get("pizza"))-1);
            dishes.add(selectedPizza);
        }
        if (!reqBody.get("panini").isEmpty()) {
            Panini selectedPanini = paniniList.get(Integer.parseInt(reqBody.get("panini"))-1);
            dishes.add(selectedPanini);
        }
        orders.createOrderAndReturn(dishes);
        res.redirect("/myOrder/" + orders.getOrderList().size());
        return "";
    }

    public String dashBoard(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        model.put("orders",orders.getOrderList());
        return  Template.render("dashboard.html", model);
    }

    public String orderDetail(Request req, Response res){

        String action = req.queryParamOrDefault("action", "");
        String value = req.queryParamOrDefault("value", "");

        String idParam = req.params(":id");
        int id = Integer.parseInt(idParam);
        int index = id - 1;

        if (action.equals("set_state")) {
            Order.State state = Order.State.valueOf(value);
            orders.getOrder(index).setState(state);
        }

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        model.put("order",orders.getOrder(index));
        return  Template.render("orderDetail.html", model);
    }

    public Object clientOrder(Request req, Response res) {

        String idParam = req.params(":id");
        int id = Integer.parseInt(idParam);
        int index = id - 1;

        Map<String, Object> model = new HashMap<>();
        model.put("order", orders.getOrder(index));
        return Template.render("clientOrder.html", model);
    }
}



