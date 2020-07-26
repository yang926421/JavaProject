package cn.gsxt.dao;
//用户操作的dao

import cn.gsxt.domain.User;

import java.util.List;

public interface userDao {
    public List<User> findAll();

    public void addOne(User user);
}
