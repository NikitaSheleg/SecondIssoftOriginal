package dao;

import entity.Order;
import entity.OrderItem;
import jdk.jshell.spi.ExecutionControl;

public class OrderDAO {
    public boolean saveOrder(Order order) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("save not implemented");
    }

    public boolean saveAllOrder(Order[] orders) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("save all not implemented");
    }

    public Order loadOrderByUserId(int userId) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("load order not implemented");

    }

    public Order[] loadOrdersByUserId(int userId) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("load orders not implemented");
    }

}
