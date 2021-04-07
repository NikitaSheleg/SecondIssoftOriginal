package service;

import dao.OrderDAO;
import dao.OrderItemDAO;
import entity.Order;
import entity.OrderState;
import jdk.jshell.spi.ExecutionControl;

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
                orderDAO.saveOrder(order);
                orderItemDAO.saveAllOrderItems(order.getOrderItems());
            } catch (ExecutionControl.NotImplementedException e) {
                return false;
            }
        } else return false;

        return true;
    }

    public Order[] loadAllByUserId(int userId) throws ExecutionControl.NotImplementedException {
        return orderDAO.loadOrdersByUserId(userId);
    }




}
