package com.demo.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.user.entity.AdvancedUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ying.zhang01
 * @date 2022/5/28
 */
@SpringBootTest
public class AdvancedUserMapperTest {
    @Autowired
    private AdvancedUserMapper advancedUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLogicDelete() {
        int i = advancedUserMapper.deleteById(7);
        System.out.println("Row Effected: " + i);

        advancedUserMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testLogicDelete2() {
        int i = userMapper.deleteById(6);
        System.out.println("Row Effected: " + i);
    }

    @Test
    public void testAutoFill() {
        AdvancedUser user = new AdvancedUser();
        user.setId(9L);
        user.setName("王一蛋");
        user.setAge(29);
        user.setEmail("yd@baomidou.com");
        user.setManagerId(2L);
        advancedUserMapper.insert(user);
    }

    @Test
    public void testTenant() {
        LambdaQueryWrapper<AdvancedUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.likeRight(AdvancedUser::getName, "王")
                .select(AdvancedUser::getName, AdvancedUser::getAge, AdvancedUser::getEmail, AdvancedUser::getManagerId);
        advancedUserMapper.selectList(wrapper);
    }
}