package entity;

import java.time.LocalDate;

public class Order {
    private int id,userid;
    private LocalDate date;
    private OrderItem[] orderItems;
    private String address;
    private OrderState state;

    public Order(int id, int userid, LocalDate date, OrderItem[] orderItems, String address, OrderState state) {
        this.id = id;
        this.userid = userid;
        this.date = date;
        this.orderItems = orderItems;
        this.address = address;
        this.state = state;
    }


    public int getId() {
        return id;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
