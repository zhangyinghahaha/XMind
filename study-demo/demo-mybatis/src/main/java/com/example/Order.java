package com.example;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderNum;
    private Date orderDate;
    private int custId;
    private Customer customer;
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", orderDate=" + orderDate +
                ", custId=" + custId +
                ", customer=" + customer +
                ", orderItems=" + orderItems +
                '}';
    }
}
