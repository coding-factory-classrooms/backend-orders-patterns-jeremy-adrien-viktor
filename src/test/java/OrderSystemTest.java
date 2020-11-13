import org.example.OrdersSystem;
import org.example.models.Dish;
import org.example.models.Ingredient;
import org.example.models.Order;
import org.example.models.Panini;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderSystemTest {
    private OrdersSystem ordersSystem;

    @Before
    public void before(){
        ordersSystem = new OrdersSystem();
    }

    @Test
    public void orderEmptyAtInitial(){
        Assert.assertTrue(ordersSystem.getOrderList().isEmpty());
    }

    @Test
    public void createAndAddOrderInOrderListSucces(){
        List<Dish> list = new ArrayList();
        Panini panini1 = new Panini(
                "panini_kebab",
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
        );
        list.add(panini1);
        ordersSystem.createOrderAndReturn(list);
        Assert.assertEquals(1,ordersSystem.getOrderList().size());
    }

    @Test
    public void orderStatAtNewWhenAdded(){
        List<Dish> list = new ArrayList();
        Panini panini1 = new Panini(
                "panini_kebab",
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
        );
        list.add(panini1);
        ordersSystem.createOrderAndReturn(list);
        Assert.assertEquals(Order.State.NEW, ordersSystem.getOrder(0).getState());
    }
}
