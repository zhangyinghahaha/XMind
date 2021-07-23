package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ying.zhang01
 */
@Mapper
public interface UserMapper {
    User selectUserByUserId(int userId);
    User selectUserByUsername(String username);
}
