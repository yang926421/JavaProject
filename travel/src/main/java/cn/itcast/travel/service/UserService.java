package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService {
    Boolean register(User user);

    boolean active(String code);

    public User login(User user);
}
