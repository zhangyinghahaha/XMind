package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectById(int id);
    User selectByName(String name);
    User selectByEmail(String email);
    int insertUser(User user);
    int updateStatus(int id, int status);
    int updateHeader(int id, String headerUrl);
    int updatePasswork(int id, String password);
}
