import org.example.OrdersSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

}
