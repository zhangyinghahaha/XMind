package com.ying.dao;

import com.ying.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 根据Id查询用户信息
     *
     * @param id
     * @return
     */
    public User queryUserById(@Param("id") int id, @Param("age") int age);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    public void deleteUser(int id);
}
