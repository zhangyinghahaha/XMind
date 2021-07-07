package com.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryUserById(int id) {
        return this.sqlSession.selectOne("com.example.selectUserById", id);
    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("com.example.selectUserAll");
    }

    public void insertUser(User user) {

    }

    public void updateUser(User user) {
        this.sqlSession.update("com.example.updateUser", user);
    }

    public static void main(String[] args) throws IOException {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 自定义DAO实现
        // UserDao userDao = new UserDaoImpl(sqlSession);
        // 使用mybatis的动态代理
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println(userDao.queryUserAll());
        User user = userDao.queryUserById(1);
        user.setEmail("zhangying111@hh.com");
        userDao.updateUser(user);
        System.out.println(userDao.queryUserById(1));
    }
}
