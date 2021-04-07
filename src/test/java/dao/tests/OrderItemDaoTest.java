package dao.tests;

import dao.OrderItemDAO;
import entity.OrderItem;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
import data.OrderItemTestData;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderItemDaoTest {

    private final OrderItemDAO orderItemDAO = new OrderItemDAO();

    @Test
    public void invalidOrderItemSaveAndLoadTest() throws ExecutionControl.NotImplementedException {
        OrderItem item = OrderItemTestData.validOrderItem();
        assertThat(orderItemDAO.saveOrderItem(item), is(true));
        assertThat(orderItemDAO.loadOrderItemByOrderItemId(item.getId()), is(not(null)));
    }

    @Test
    public void invalidOrderItemsSaveAndLoadTest() throws ExecutionControl.NotImplementedException {
        OrderItem[] items = OrderItemTestData.validOrderItems();
        assertThat(orderItemDAO.saveAllOrderItems(items),is(true));
        assertThat(orderItemDAO.loadAllItems(),is(not(null)));
    }


}
