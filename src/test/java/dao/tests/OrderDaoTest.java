package dao.tests;

import dao.OrderDAO;
import entity.Order;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
import data.OrderTestData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderDaoTest {

    private final OrderDAO orderDAO = new OrderDAO();

    @Test
    public void invalidSaveAndLoadTest() throws ExecutionControl.NotImplementedException {
        Order order = OrderTestData.getAnyValidOrder();
        assertThat(orderDAO.saveOrder(order), is(true));
        assertThat(orderDAO.loadOrderByUserId(order.getUserid()), is(equalTo(order)));
    }

    @Test
    public void invalidSaveOrdersTest() throws ExecutionControl.NotImplementedException {
        Order[] orders = OrderTestData.getValidOrders();
        assertThat(orderDAO.saveAllOrder(orders), is(true));
    }

    @Test
    public void invalidLoadOrdersByUserIdTest() throws ExecutionControl.NotImplementedException {
        assertThat(orderDAO.loadOrdersByUserId(1), is(not(null)));
    }

}
