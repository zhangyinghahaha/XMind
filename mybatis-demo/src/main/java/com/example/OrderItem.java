package com.example;

public class OrderItem {
    private int orderNum;
    private int orderItem;
    private String prodId;
    private Float itemPrice;

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderNum=" + orderNum +
                ", orderItem=" + orderItem +
                ", prodId='" + prodId + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
