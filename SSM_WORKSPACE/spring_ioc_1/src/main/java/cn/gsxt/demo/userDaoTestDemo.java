package cn.gsxt.demo;

import cn.gsxt.mapper.userDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class userDaoTestDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao userDao = (userDao) app.getBean("userDao");
        userDao.save();
    }
}
