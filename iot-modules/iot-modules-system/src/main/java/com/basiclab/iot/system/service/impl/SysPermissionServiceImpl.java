package com.basiclab.iot.system.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.basiclab.iot.system.api.domain.SysUser;
import com.basiclab.iot.system.service.ISysMenuService;
import com.basiclab.iot.system.service.ISysPermissionService;
import com.basiclab.iot.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl implements ISysPermissionService
{
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysMenuService menuService;

    /**
     * 获取角色数据权限
     * 
     * @param userId 用户Id
     * @return 角色权限信息
     */
    @Override
    public Set<String> getRolePermission(Long userId)
    {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (SysUser.isAdmin(userId))
        {
            roles.add("admin");
        }
        else
        {
            roles.addAll(roleService.selectRolePermissionByUserId(userId));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     * 
     * @param userId 用户Id
     * @return 菜单权限信息
     */
    @Override
    public Set<String> getMenuPermission(Long userId)
    {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (SysUser.isAdmin(userId))
        {
            perms.add("*:*:*");
        }
        else
        {
            perms.addAll(menuService.selectMenuPermsByUserId(userId));
        }
        return perms;
    }
}
