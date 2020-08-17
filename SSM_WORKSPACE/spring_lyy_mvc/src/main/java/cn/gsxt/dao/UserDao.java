package cn.gsxt.dao;

import cn.gsxt.domain.Role;
import cn.gsxt.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void del(Long userId);

    void delUserRoleRel(Long userId);
}
