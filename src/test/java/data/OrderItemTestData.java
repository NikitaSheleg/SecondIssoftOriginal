package data;

import entity.OrderItem;

public class OrderItemTestData {
    public static OrderItem[] validOrderItems() {
        return new OrderItem[]{ new OrderItem("item1", 12, 2,0,1),
                new OrderItem("item2", 14, 3,1,1)};
    }

    public static OrderItem validOrderItem() {
        return new OrderItem("item", 16,2,3,2);
    }
}
