package cn.gsxt.dao;
//用户操作的dao

import cn.gsxt.domain.User;

import java.util.List;

public interface userDao {
    public List<User> findAll();

    public void addOne(User user);

    User findUserByUsernameAndPassword(String username, String password);

    void delUserById(int parseInt);

    User findUserById(int parseInt);

    void updateUser(User user);
}
