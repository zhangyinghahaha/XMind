package com.demo;

import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author ying.zhang01
 */
public class MapperTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.setId(1);
        order.setName("test order 1");

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setOrderId(1);
        orderItem1.setPrice("12");
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setOrderId(1);
        orderItem2.setPrice("20");
        List<OrderItem> orderItems = List.of(orderItem1, orderItem2);

        OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
        OrderDTO orderDTO = orderMapper.toDTO(order, orderItems);
        System.out.println(orderDTO);
    }
}
