package serviceTest;

import dao.OrderDAO;
import dao.OrderItemDAO;
import entity.Order;
import entity.OrderItem;
import entity.OrderState;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.OrderService;
import service.OrderValidator;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private OrderService orderService;
    @Mock
    private OrderValidator orderValidator;
    @Mock
    private OrderDAO orderDAO;
    @Mock
    private OrderItemDAO orderItemDAO;
    
    @BeforeEach
    public void beforeTest() throws ExecutionControl.NotImplementedException {
        MockitoAnnotations.initMocks(this);
        when(orderDAO.saveOrder(any())).thenReturn(true);
        orderService = new OrderService(orderValidator, orderDAO, orderItemDAO);
    }



    @Test
    void validTestForPlaceOrder() throws ExecutionControl.NotImplementedException {
        when(orderDAO.loadOrderByUserId(1)).thenReturn(null);
        OrderItem[] items = {new OrderItem("item1", 24, 2,1)};
        Order order = new Order(1, 1, LocalDate.now(), items, "addr");
        when(orderValidator.validate(order)).thenReturn(true);
        orderService.placeOrder(order);
        verify(orderDAO).saveOrder(order);
        assertThat(order.getState(), is(OrderState.INIT));
    }

    @Test
    void validTestForLoadAllByUserId() throws ExecutionControl.NotImplementedException {
        when(orderDAO.loadOrdersByUserId(1)).thenReturn(null);
        orderService.loadAllByUserId(1);
        verify(orderDAO).loadOrdersByUserId(1);
    }

}
