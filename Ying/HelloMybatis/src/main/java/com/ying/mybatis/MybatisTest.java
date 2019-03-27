package com.ying.mybatis;

import com.ying.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ying.dao.UserDao;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件(Resources工具类专门用来加载资源文件)
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory(每个基于MyBatis的应用都是以SqlSessionFactory为核心)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 从SqlSessionFactory获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            //User user = sqlSession.selectOne("com.ying.mapper.UserMapper.selectUser", "10000");
            //System.out.println(user);

            //UserDao userDao = sqlSession.getMapper(UserDao.class);
            //User user = userDao.queryUserById(10000);
            //List<User> userList = userDao.queryUserAll();
            //System.out.println(user);
//            for(User temp : userList) {
//                System.out.println(temp);
//            }

        } finally {
            sqlSession.close();
        }
    }
}