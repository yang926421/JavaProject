package cn.gsxt.service.impl;

import cn.gsxt.dao.RoleDao;
import cn.gsxt.domain.Role;
import cn.gsxt.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        System.out.println("roleService");
        List<Role> roleList = roleDao.findAll();
        System.out.println(roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
