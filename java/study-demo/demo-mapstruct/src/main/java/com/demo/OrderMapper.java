package com.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Mapping(source = "order.name", target = "number")
    @Mapping(source = "orderItems", target = "orderItemDTOS")
    @Mapping(source = "orderItems", target = "orderItemDTOMap")
    OrderDTO toDTO(Order order, List<OrderItem> orderItems);

    @Mapping(source = "price", target = "price2")
    OrderItemDTO toDTO(OrderItem orderItem);
}
