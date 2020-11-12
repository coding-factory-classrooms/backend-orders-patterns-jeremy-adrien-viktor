package org.example;

import org.example.controllers.OrderController;
import org.example.core.Conf;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import org.example.models.Dish;
import org.example.models.Ingredient;
import org.example.models.Panini;
import org.example.models.Pizza;
import spark.Spark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        initialize();

        List<Pizza> pizzaList = ourPizza();
        List<Panini> paniniList = ourPanini();

        Map<String, Object> model = new HashMap<>();
        model.put("pizzaList", pizzaList);
        model.put("paniniList", paniniList);


        Spark.get("/", (req, res) -> {
            return Template.render("home.html", model);
        });
    }

    private static List<Panini> ourPanini() {
        List<Panini> paniniList = new ArrayList<>();

        paniniList.add(
                new Panini(
                        "PANINI KEBAB",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Viande kebab"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Sauce blanche"));
                            }
                        },
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés"
                )
        );

        paniniList.add(
                new Panini(
                        "PANINI KEBAB",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Viande kebab"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Sauce blanche"));
                            }
                        },
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés"
                )
        );
        paniniList.add(
                new Panini(
                        "PANINI KEBAB",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Viande kebab"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Sauce blanche"));
                            }
                        },
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés"
                )
        );

        return paniniList;
    }

    private static List<Pizza> ourPizza() {
        List<Pizza> pizzaList = new ArrayList<>();

        pizzaList.add(
                new Pizza(
                        "SAVOUREUSE FONDUE",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Lardons"));
                                add(new Ingredient("Fromage"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Crème fraîche"));
                            }
                        },
                        Pizza.DoughType.CLASSIC,
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés"
                )
        );

        pizzaList.add(
                new Pizza(
                        "SAVOUREUSE FONDUE",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Lardons"));
                                add(new Ingredient("Fromage"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Crème fraîche"));
                            }
                        },
                        Pizza.DoughType.CLASSIC,
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés"
                )
        );
        pizzaList.add(
                new Pizza(
                        "SAVOUREUSE FONDUE",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Lardons"));
                                add(new Ingredient("Fromage"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Crème fraîche"));
                            }
                        },
                        Pizza.DoughType.CLASSIC,
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés"
                )
        );
        pizzaList.add(
                new Pizza(
                        "SAVOUREUSE FONDUE",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Lardons"));
                                add(new Ingredient("Fromage"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Crème fraîche"));
                            }
                        },
                        Pizza.DoughType.CLASSIC,
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), lardons fumés"
                )
        );

        return pizzaList;
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
