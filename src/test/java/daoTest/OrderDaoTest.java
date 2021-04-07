package daoTest;

import dao.OrderDAO;
import entity.Order;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
import testData.OrderTestData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderDaoTest {

   private final OrderDAO orderDAO = new OrderDAO();
    @Test
    public void saveTest() throws ExecutionControl.NotImplementedException {
        Order order = OrderTestData.getAnyValidOrder();
        assertThat(orderDAO.saveOrder(order), is(true));
        assertThat(orderDAO.loadOrderByUserId(order.getUserid()), is(equalTo(order)));
    }
}
