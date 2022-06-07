package com.demo.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author ying.zhang01
 * @date 2022/5/27
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
//        User user = userMapper.selectOne(null);
    }

    @Test
    public void testSelectMap() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "email").likeRight("name", "黄");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);

        QueryWrapper<User> query2 = new QueryWrapper<>();
        query2.select("manager_id", "avg(age) avg_age", "min(age) min_age", "max(age) max_age")
                .groupBy("manager_id")
                .having("sum(age) < {0}", 500);
        maps = userMapper.selectMaps(query2);
        maps.forEach(System.out::println);
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectAll(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getAge, 28);

        Page<User> page = new Page<>(1, 2);

        Page<User> pageUser = userMapper.selectPage(page, wrapper);
        pageUser.getRecords().forEach(System.out::println);

        page.setCurrent(2);
        pageUser = userMapper.selectUserPage(page, wrapper);
        pageUser.getRecords().forEach(System.out::println);
    }

    @Test
    public void testAuto() {
        User user = new User();
        user.setName("我是青蛙呱呱");
        user.setAge(99);
        user.setEmail("frog@baomidou.com");
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
        System.out.println(user.getId());
    }

}
