package cn.gsxt.service;

import cn.gsxt.domain.User;

import java.util.List;

public interface userService {
    public List<User> findAll();

    public void addOne(User user);

    User login(User user);

    void delUserById(int parseInt);

    User findUserById(int parseInt);

    public void updateUser(User user);

    void delSelectedUser(String[] ids);
}
