package service;

import entity.Order;

public class OrderValidator {

    public boolean validate(Order order) {
        return order.getOrderItems() != null &&
                order.getAddress() != null &&
                order.getDate() != null &&
                order.getState() != null;
    }
}
