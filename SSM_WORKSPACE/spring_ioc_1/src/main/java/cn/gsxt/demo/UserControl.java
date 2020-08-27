package cn.gsxt.demo;

import cn.gsxt.service.UserService;
import cn.gsxt.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserControl {
    public static void main(String[] args) {
        //模拟wab层
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
