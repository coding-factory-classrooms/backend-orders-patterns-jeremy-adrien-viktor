import org.example.models.Dish;
import org.example.models.Ingredient;
import org.example.models.Order;
import org.example.models.Panini;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class OrderTest {

    private Order order;

    @Before
    public void before(){
        order = new Order();
    }

    @Test
    public void setStateShouldTriggerListener(){
        Order.OnStateChangedListener listener = Mockito.mock(Order.OnStateChangedListener.class);

        order.setStateChangedListener(listener);
        order.setState(Order.State.IN_PROGRESS);

        Mockito.verify(listener).onSateChanged(order);
    }



}
