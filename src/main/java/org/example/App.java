package org.example;

import org.example.controllers.OrderController;
import org.example.core.Conf;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import org.example.models.Dish;
import org.example.models.Ingredient;
import org.example.models.Pizza;
import spark.Spark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        initialize();

        List<Pizza> pizzaList = new ArrayList<>();

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Lardons"));
        ingredients.add(new Ingredient("Fromage"));
        ingredients.add(new Ingredient("Mozzarella"));
        ingredients.add(new Ingredient("Crème fraîche"));

        Pizza pizza = new Pizza("SAVOUREUSE FONDUE",ingredients, Pizza.DoughType.CLASSIC,11.5f,"Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés");
        pizzaList.add(pizza);
        pizzaList.add(pizza);
        pizzaList.add(pizza);
        pizzaList.add(pizza);

        Map<String, Object> model = new HashMap<>();
        model.put("pizzaList", pizzaList);

        Spark.get("/", (req, res) -> {
            return Template.render("home.html", model);
        });
    }

    static void initialize() {
        Template.initialize();

        // Display exceptions in logs
        Spark.exception(Exception.class, (e, req, res) -> e.printStackTrace());

        // Serve static files (img/css/js)
        Spark.staticFiles.externalLocation(Conf.STATIC_DIR.getPath());

        // Configure server port
        Spark.port(Conf.HTTP_PORT);
        final LoggerMiddleware log = new LoggerMiddleware();
        Spark.before(log::process);
    }
}
