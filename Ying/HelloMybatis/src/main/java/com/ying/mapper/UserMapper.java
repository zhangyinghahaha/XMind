package com.ying.mapper;

import com.ying.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper interface
 *
 * @author ying.zhang01
 * @date 2019/5/7
 */
public interface UserMapper {

    /**
     * 登录（直接使用注解指定传入参数名称）
     * @param userName
     * @param password
     * @return
     */
    public User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */
    public List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户信息
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据id更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(int id);

    /**
     * 查询男性用户，如果输入了姓名，则按姓名查询
     * @param name
     * @return
     */
    List<User> queryUserList(@Param("name") String name);

    /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameOrAge(@Param("name") String name, @Param("age") Integer age);

    List<User> queryUserListByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    List<User> queryUserListByIds(@Param("ids") String[] ids);

}


