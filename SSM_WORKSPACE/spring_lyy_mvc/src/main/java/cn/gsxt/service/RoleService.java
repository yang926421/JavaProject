package cn.gsxt.service;

import cn.gsxt.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
