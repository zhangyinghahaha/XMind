package com.ying.mapper;


import com.ying.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * UserMapperTest class
 *
 * @author ying.zhang01
 * @date 2019/5/7
 */
public class UserMapperTest {

    public UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testQueryUserByTableName() {
        List<User> userList = userMapper.queryUserByTableName("tb_user");
        System.out.println(userList);
    }

    @Test
    public void testLogin() {
        System.out.println(this.userMapper.login("hj", "123456"));
    }

    @Test
    public void testQueryUserById() {
        System.out.println(this.userMapper.queryUserById(1l));
    }

    @Test
    public void testQueryUserAll() {
        List<User> userList = this.userMapper.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("大神");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("bigGod222");
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId(1);
        this.userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        this.userMapper.deleteUserById(1);
    }
}

