package cn.gsxt.service.impl;

import cn.gsxt.module.User;
import cn.gsxt.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findAll() {
        System.out.println(123456);
        return null;
    }
}
