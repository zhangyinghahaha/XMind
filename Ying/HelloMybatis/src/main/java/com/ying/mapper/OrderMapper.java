package com.ying.mapper;

import com.ying.bean.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    /**
     * 根据订单号查询订单用户信息
     * @param number
     * @return
     */
    Order queryOrderWithUserByOrderNumber(@Param("number") String number);

    Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);
}
