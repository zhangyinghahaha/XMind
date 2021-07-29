package com.demo.service;

import com.demo.entity.Role;
import com.demo.mapper.RoleMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleMapper roleMapper;

    public RoleService(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public int addRole(Role role) {
        return roleMapper.insertRole(role);
    }

    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    public int deleteRoleById(int roleId) {
        return roleMapper.deleteRoleById(roleId);
    }

    public List<Role> getRoles(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> roleMapper.selectAllRoles());
    }

    public Role getRoleById(int roleId) {
        return roleMapper.selectRoleById(roleId);
    }

    public List<Integer> getRoleIdsByUserId(int userId) {
        return roleMapper.selectRoleIdsByUserId(userId);
    }

    int deleteRolesByUserId(int userId) {
        return roleMapper.deleteRoleIdsByUserId(userId);
    }

    int addRolesByUserId(int userId, List<Integer> roleIds) {
        return roleMapper.insertRolesByUserId(userId, roleIds);
    }
}
