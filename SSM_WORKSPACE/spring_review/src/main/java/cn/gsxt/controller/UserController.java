package cn.gsxt.controller;


import cn.gsxt.module.User;
import cn.gsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    private UserService userService;

    public void test(){
        User userServiceAll = userService.findAll();
    }
}
