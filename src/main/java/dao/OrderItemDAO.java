package dao;

import entity.OrderItem;
import jdk.jshell.spi.ExecutionControl;

public class OrderItemDAO {
    public boolean saveOrderItem(OrderItem orderItem) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("save not implemented");
    }

    public boolean saveAllOrderItems(OrderItem[] orderItems) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("save all not implemented");
    }

    public OrderItem loadOrderItemByOrderItemId(int itemId) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("load item not implemented");

    }

    public OrderItem[] loadAllItems() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("load items not implemented");
    }
}
