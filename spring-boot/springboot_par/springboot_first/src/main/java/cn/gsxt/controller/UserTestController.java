package cn.gsxt.controller;


import cn.gsxt.domain.User;
import cn.gsxt.mapper.UserMapper;
import cn.gsxt.mapper.UserMapperTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserTestController {
    @Autowired
    private UserMapperTest userMapperTest;

    @RequestMapping("/selectById1")
    public User test(){
        return userMapperTest.SelectById(1);
    }

    @RequestMapping("/selectAll")
    public List<User> test1(){
        return userMapperTest.selectAll();
    }
}
