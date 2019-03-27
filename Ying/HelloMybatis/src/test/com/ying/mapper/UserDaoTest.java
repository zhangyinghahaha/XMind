package com.ying.mapper;

import com.ying.bean.User;
import com.ying.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

import static org.junit.Assert.*;

public class UserDaoTest {

    public UserDao userDao;
    public SqlSession sqlSession;

    @org.junit.Before
    public void setUp() throws Exception {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件(Resources工具类专门用来加载资源文件)
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory(每个基于MyBatis的应用都是以SqlSessionFactory为核心)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 从SqlSessionFactory获取SqlSession
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @org.junit.Test
    public void queryUserById() {
        System.out.println(userDao.queryUserById(10000, 18));
    }

    @org.junit.Test
    public void queryUserAll() {
        System.out.println(userDao.queryUserAll());
    }

    @org.junit.Test
    public void insertUser() {
        User user = new User();
        user.setAge(16);
        user.setName("张颖");
        userDao.insertUser(user);
        sqlSession.commit();
    }

    @org.junit.Test
    public void updateUser() {
        User user = new User();
        user.setAge(18);
        user.setId(10000);
        userDao.updateUser(user);
        sqlSession.commit();
        //System.out.println(userDao.queryUserById(10000));
    }

    @org.junit.Test
    public void deleteUser() {
        userDao.deleteUser(10002);
        sqlSession.commit();
    }
}