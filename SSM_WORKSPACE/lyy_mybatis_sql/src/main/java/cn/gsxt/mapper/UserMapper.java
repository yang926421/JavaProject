package cn.gsxt.mapper;

import cn.gsxt.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();

    public List<User> findUserAndRoleAll();
}
