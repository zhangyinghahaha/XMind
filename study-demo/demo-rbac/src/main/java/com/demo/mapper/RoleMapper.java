package com.demo.mapper;

import com.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ying.zhang01
 */
@Mapper
public interface RoleMapper {
    int insertRole(Role role);
    int updateRole(Role role);
    int deleteRoleById(int roleId);
    List<Role> selectAllRoles();
    Role selectRoleById(int roleId);

    /**
     * 根据用户Id查询所有角色Id
     * @param userId
     * @return
     */
    List<Integer> selectRoleIdsByUserId(int userId);

    /**
     * 根据用户Id删除所有角色
     * @param userId
     * @return
     */
    int deleteRoleIdsByUserId(int userId);

    /**
     * 根据用户Id批量插入角色
     * @param userId
     * @param roleIds
     * @return
     */
    int insertRolesByUserId(int userId, List<Integer> roleIds);
}
