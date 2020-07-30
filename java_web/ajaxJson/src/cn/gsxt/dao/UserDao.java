package cn.gsxt.dao;

import cn.gsxt.domain.User;

public interface UserDao {
    public User SelectUserByUsername(String username);
}
