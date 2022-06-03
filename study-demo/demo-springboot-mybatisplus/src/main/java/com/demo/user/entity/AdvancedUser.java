package com.demo.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ying.zhang01
 * @date 2022/5/28
 */
@Data
public class AdvancedUser {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    private Integer version;

    @TableLogic(value = "0", delval = "1")
    @TableField(select = false)
    private Integer deleted;
}