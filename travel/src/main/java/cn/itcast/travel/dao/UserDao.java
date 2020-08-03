package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    public User findUserByUsername(String username);

    public void save(User user);


    User findUserByCode(String code);

    void updateStatus(User user);
}
