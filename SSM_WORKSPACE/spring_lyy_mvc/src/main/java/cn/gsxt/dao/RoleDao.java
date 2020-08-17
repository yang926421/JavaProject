package cn.gsxt.dao;

import cn.gsxt.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
