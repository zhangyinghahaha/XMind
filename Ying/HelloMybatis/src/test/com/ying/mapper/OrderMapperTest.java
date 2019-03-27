package com.ying.mapper;

import com.ying.bean.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class OrderMapperTest {

    public OrderMapper orderMapper;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件(Resources工具类专门用来加载资源文件)
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory(每个基于MyBatis的应用都是以SqlSessionFactory为核心)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 从SqlSessionFactory获取SqlSession
        sqlSession = sqlSessionFactory.openSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderWithUserByOrderNumber() {
        Order order = orderMapper.queryOrderWithUserByOrderNumber("201807010001");
        System.out.println(order.getUser());
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() {
        Order order = orderMapper.queryOrderWithUserAndDetailByOrderNumber("201807010001");
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }
}