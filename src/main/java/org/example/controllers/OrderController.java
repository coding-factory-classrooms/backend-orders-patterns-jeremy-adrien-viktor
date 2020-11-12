package org.example.controllers;

import org.example.Order;
import org.example.core.Template;
import org.example.models.Panini;
import org.example.models.Pizza;
import org.example.utils.URLUtils;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {

    private Order orders;
    private  final List<Pizza> pizzaList;
    private  final List<Panini> paniniList;

    public OrderController(Order orders, List<Pizza> pizzaList, List<Panini> paniniList) {
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

        Map<String, Object> model = new HashMap<>();
        return Template.render("clientOrder.html",model);
    }
}



