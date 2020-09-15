package cn.gsxt.service.impl;

import cn.gsxt.mapper.userDao;
import cn.gsxt.service.UserService;

public class UserServiceImpl implements UserService {
    private userDao userDao;
//
//    public void setUserDao(cn.gsxt.dao.userDao userDao) {
//        this.userDao = userDao;
//    }

    public UserServiceImpl() {
    }

    public UserServiceImpl(cn.gsxt.mapper.userDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        userDao userDao = (userDao)app.getBean("userDao");
        //在容器内部将userDao注入userService
        userDao.save();
    }
}
