package testData;

import entity.Order;
import entity.OrderItem;

import java.time.LocalDate;

public class OrderTestData {


    public static Order validOrder(int userId) {
        OrderItem[] items = {new OrderItem("item1", 24, 2, 1)};
        Order order = new Order(1, userId, LocalDate.now(), items, "address");
        order.setOrderItems(items);

        return order;
    }

    public static Order getAnyValidOrder() {
        return validOrder(12);
    }

}
