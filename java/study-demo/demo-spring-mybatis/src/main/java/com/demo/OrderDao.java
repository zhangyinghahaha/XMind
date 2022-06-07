package com.demo;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ying.zhang01
 */
@Component
public class OrderDao extends SqlSessionDaoSupport {

    @Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public Order queryOrderByNumber(int number) {
        Order order = getSqlSession().selectOne("com.demo.OrderMapper.queryOrderByNumber", number);
        return order;
    }
}
