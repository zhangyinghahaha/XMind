package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ying.zhang01
 */
@Mapper
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户Id删除用户
     * @param userId
     * @return
     */
    int deleteUserById(int userId);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser();

    /**
     * 根据用户Id查询用户
     * @param userId
     * @return
     */
    User selectUserByUserId(int userId);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User selectUserByUsername(String username);
}
