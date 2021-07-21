package com.demo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhangying
 */
@Mapper
public interface OrderMapper {
    Order queryOrderByNumber(int number);
    List<Order> queryOrder();
}
