package cn.gsxt.service;

import cn.gsxt.config.TestConfig;
import cn.gsxt.mapper.UserMapper;
import cn.gsxt.module.User;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestConfig testConfig;


    public void getAllUsers(){
        System.out.println("123456");
//        testConfig.test1();

        List<User> allUsers = userMapper.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);

        }
    }
}
