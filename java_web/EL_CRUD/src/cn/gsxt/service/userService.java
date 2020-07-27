package cn.gsxt.service;

import cn.gsxt.domain.User;

import java.util.List;

public interface userService {
    public List<User> findAll();

    public void addOne(User user);
}
