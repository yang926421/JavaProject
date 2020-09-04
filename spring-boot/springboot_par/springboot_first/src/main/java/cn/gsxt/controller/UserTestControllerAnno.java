package cn.gsxt.controller;


import cn.gsxt.domain.User;
import cn.gsxt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestControllerAnno {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/selectById")
    public User test(){
        return userMapper.SelectById(1);
    }
}
