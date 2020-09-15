package cn.gsxt.mapper;

import cn.gsxt.module.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUserList();

    // 增加用户
    public void insertUser(User user);

    //根据Id查询用户
    public User findUserById(int id);

    //根据Id查询用户
    public void updateUser(User user);
}
