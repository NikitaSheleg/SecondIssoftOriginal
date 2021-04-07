package service.tests;

import dao.OrderDAO;
import dao.OrderItemDAO;
import data.OrderTestData;
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void validTestForPlaceOrder() throws ExecutionControl.NotImplementedException {
        Order order = OrderTestData.getAnyValidOrder();
        when(orderValidator.validate(order)).thenReturn(true);
        orderService.placeOrder(order);
        verify(orderDAO).saveOrder(order);
        assertThat(order.getState(), is(OrderState.INIT));
    }

    @Test
    public void invalidTestForPlaceOrder() throws ExecutionControl.NotImplementedException {
        Order order = OrderTestData.getAnyValidOrder();
        when(orderValidator.validate(order)).thenReturn(true);
        when(orderItemDAO.saveAllOrderItems(order.getOrderItems())&&orderDAO.saveOrder(order)).thenReturn(false);
        assertThat(orderService.placeOrder(order), is(true));
    }

    @Test
    public void validTestForLoadAllByUserId() throws ExecutionControl.NotImplementedException {
        when(orderDAO.loadOrdersByUserId(1)).thenReturn(OrderTestData.getValidOrders());
        orderService.loadAllByUserId(1);
        verify(orderDAO).loadOrdersByUserId(1);
    }

    @Test
    public void validTestForLoadOneOrderByUserId() throws ExecutionControl.NotImplementedException {
        when(orderDAO.loadOrderByUserId(1)).thenReturn(OrderTestData.getAnyValidOrder());
        orderService.loadOrderByUserId(1);
        verify(orderDAO).loadOrderByUserId(1);
    }

    @Test
    public void invalidTestForLoadOrderByUserId() throws NullPointerException, ExecutionControl.NotImplementedException {
        when(orderDAO.loadOrderByUserId(1)).thenReturn(OrderTestData.getAnyValidOrder());
        orderService.loadOrderByUserId(2);
        verify(orderDAO).loadOrderByUserId(1);
    }


}
