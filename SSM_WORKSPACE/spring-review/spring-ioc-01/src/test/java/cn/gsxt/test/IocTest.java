package cn.gsxt.test;

import cn.gsxt.module.User;
import cn.gsxt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IocTest {

    @Autowired
    private UserService userService;


    @Test
    public void test(){
        //获取spring的上下文对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        User user = (User)context.getBean("user");
        userService.test1();


    }

}
