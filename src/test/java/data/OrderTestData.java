package data;

import entity.Order;
import entity.OrderItem;
import entity.OrderState;

import java.time.LocalDate;

public class OrderTestData {


    public static Order validOrder(int userId) {
        OrderItem[] items = {new OrderItem("item1", 24, 2, 1, 1)};
        Order order = new Order(1, userId, LocalDate.now(), items, "address", OrderState.INIT);
        order.setOrderItems(items);

        return order;
    }

    public static Order getAnyValidOrder() {
        return validOrder(12);
    }

    public static Order[] getValidOrders() {
        OrderItem[] items = {new OrderItem("item1", 24, 2, 1, 1)};
        return new Order[]{new Order(1, 1, LocalDate.now(), items, "addr",OrderState.INIT)};
    }

}
