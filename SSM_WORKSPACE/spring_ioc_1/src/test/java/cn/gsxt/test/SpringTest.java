package cn.gsxt.test;

import cn.gsxt.dao.userDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao userDao = (userDao) app.getBean("userDao");
        System.out.println(userDao);
    }
}
