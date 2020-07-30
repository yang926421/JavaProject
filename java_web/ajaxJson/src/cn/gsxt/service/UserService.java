package cn.gsxt.service;

import cn.gsxt.domain.User;

public interface UserService {
    public User SelectUserByUsername(String username);
}
