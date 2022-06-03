package com.demo.user.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ying.zhang01
 * @date 2022/5/27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 自定义查找
     * @param wrapper where条件
     * @return List
     */
    List<User> selectAll(@Param(Constants.WRAPPER)Wrapper<User> wrapper);

    /**
     * 自定义分页查询
     * @param page 分页
     * @param wrapper where
     * @return 分页数据
     */
    Page<User> selectUserPage(Page<User> page, @Param(Constants.WRAPPER)Wrapper<User> wrapper);
}
