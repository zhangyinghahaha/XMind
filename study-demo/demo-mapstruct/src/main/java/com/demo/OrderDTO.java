package com.demo;

import java.util.List;
import java.util.Map;

/**
 * @author ying.zhang01
 */
public class OrderDTO {
    private Integer id;
    private String number;
    private List<OrderItemDTO> orderItemDTOS;
    private Map<String, OrderItemDTO> orderItemDTOMap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<OrderItemDTO> getOrderItemDTOS() {
        return orderItemDTOS;
    }

    public void setOrderItemDTOS(List<OrderItemDTO> orderItemDTOS) {
        this.orderItemDTOS = orderItemDTOS;
    }

    public Map<String, OrderItemDTO> getOrderItemDTOMap() {
        return orderItemDTOMap;
    }

    public void setOrderItemDTOMap(Map<String, OrderItemDTO> orderItemDTOMap) {
        this.orderItemDTOMap = orderItemDTOMap;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", orderItems=" + orderItemDTOS +
                '}';
    }
}
