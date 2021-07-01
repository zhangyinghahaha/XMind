package com.nowcoder.community.dao.dao;

import com.nowcoder.community.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    User selectById(int id);
    User selectByName(String name);
    User selectByEmail(String email);
    int insertUser(User user);
    int updateStatus(int id, int status);
    int updateHeader(int id, String headerUrl);
    int updatePasswork(int id, String password);
}
