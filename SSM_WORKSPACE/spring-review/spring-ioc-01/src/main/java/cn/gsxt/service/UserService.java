package cn.gsxt.service;


import cn.gsxt.dao.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    @Test
    public void test(){
        System.out.println(userDao.getClass());
    }

    public void test1(){
        System.out.println("哈哈哈");
    }
}
