package com.demo;

/**
 * @author ying.zhang01
 */
public class OrderItemDTO {
    private Integer orderId;
    private String price2;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price) {
        this.price2 = price;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "orderId=" + orderId +
                ", price='" + price2 + '\'' +
                '}';
    }
}
