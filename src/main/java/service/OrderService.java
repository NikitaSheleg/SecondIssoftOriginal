package service;

import dao.OrderDAO;
import dao.OrderItemDAO;
import entity.Order;
import entity.OrderState;
import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;

public class OrderService {
    private final OrderValidator orderValidator;
    private final OrderDAO orderDAO;
    private final OrderItemDAO orderItemDAO;

    public OrderService(OrderValidator orderValidator, OrderDAO orderDAO, OrderItemDAO orderItemDAO) {
        this.orderValidator = orderValidator;
        this.orderDAO = orderDAO;
        this.orderItemDAO = orderItemDAO;
    }

    public boolean placeOrder(Order order) {
        if (orderValidator.validate(order)) {
            try {
                order.setState(OrderState.INIT);
                if ( orderDAO.saveOrder(order)&& orderItemDAO.saveAllOrderItems(order.getOrderItems()))
                    return true;
               ;
            } catch (ExecutionControl.NotImplementedException e) {
                return false;
            }
        } else return false;

        return false;
    }

    public Order[] loadAllByUserId(int userId) throws ExecutionControl.NotImplementedException {
        Order[] orders = orderDAO.loadOrdersByUserId(userId);
        Arrays.stream(orders).forEach(order -> {
            try {
                order.setOrderItems(orderItemDAO.loadAllItemsByOrderId(order.getId()));
            } catch (ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        });
        return orders;
    }

    public Order loadOrderByUserId(int userId) throws ExecutionControl.NotImplementedException {
        Order order = orderDAO.loadOrderByUserId(userId);
        order.setOrderItems(orderItemDAO.loadAllItemsByOrderId(order.getId()));
        return order;
    }


}
