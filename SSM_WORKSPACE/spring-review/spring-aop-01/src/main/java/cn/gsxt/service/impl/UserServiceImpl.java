package cn.gsxt.service.impl;

import cn.gsxt.log.AfterLog;
import cn.gsxt.service.UserService;
import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("userService")
public class UserServiceImpl implements UserService {

    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("修改了一个用户");
    }

    public void query() {
        System.out.println("查询到了一个用户");
    }

}
