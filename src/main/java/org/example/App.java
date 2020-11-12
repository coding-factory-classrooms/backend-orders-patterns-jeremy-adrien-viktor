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
                        "PANINI 3 FROMAGES",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Chèvre"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("gorgonzola"));
                                add(new Ingredient("Fromage à la crème"));
                            }
                        },
                        11.5f,
                        "Faites place à l'onctuosité et à la gourmandise avec ce panini 3 fromages composé de mozzarella, chèvre, gorgonzola et sauce crémée"
                )
        );
        paniniList.add(
                new Panini(
                        "PANINI POULET",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Poulet"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Batavia"));
                                add(new Ingredient("Fromage à la crème"));
                                add(new Ingredient("Oignons"));
                            }
                        },
                        11.5f,
                        "Découvrez notre panini au poulet aussi savoureux que léger avec son poulet, mozzarella, salade, fromage à la crème et oignons"
                )
        );
        paniniList.add(
                new Panini(
                        "PANINI SAUMON",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Saumon fumé"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Batavia"));
                                add(new Ingredient("Fromage à la crème"));
                                add(new Ingredient("Tomates"));
                            }
                        },
                        11.5f,
                        "Le panini au saumon composé de saumon fumé, mozzarella, salade, fromage à la crème et tomate fraîche  sera parfait si vous cherchez un plat délicat et frais"
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
                        "AUTHENTIQUE RACLETTE",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Crème fraîche"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Bacon"));
                                add(new Ingredient("Oignons"));
                                add(new Ingredient("Pomme de terre"));
                                add(new Ingredient("Fromage à raclette"));
                            }
                        },
                        Pizza.DoughType.CLASSIC,
                        11.5f,
                        "Crème fraîche légère française, mozzarella, bacon, oignons, pommes de terre sautées, raclette française"
                )
        );
        pizzaList.add(
                new Pizza(
                        "Généreuse Avalanche",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Reblochon"));
                                add(new Ingredient("Fromage"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Crème fraîche"));
                            }
                        },
                        Pizza.DoughType.CLASSIC,
                        11.5f,
                        "Crème fraîche légère française, mozzarella, mélange fondue aux 3 fromages (emmental, gruyère et beaufort), Reblochon AOP de Savoie."
                )
        );
        pizzaList.add(
                new Pizza(
                        "Urban Kebab",
                        new ArrayList<>() {
                            {
                                add(new Ingredient("Tomate"));
                                add(new Ingredient("Viande Kebab"));
                                add(new Ingredient("Mozzarella"));
                                add(new Ingredient("Merguez"));
                                add(new Ingredient("Oignons"));
                                add(new Ingredient("Sauce blanche"));
                            }
                        },
                        Pizza.DoughType.CLASSIC,
                        11.5f,
                        "Sauce tomate, mozzarella, viande kebab, merguez, oignons, sauce blanche kebab"
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
