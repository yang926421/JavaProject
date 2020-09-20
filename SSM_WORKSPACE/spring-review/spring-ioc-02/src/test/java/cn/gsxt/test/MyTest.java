package cn.gsxt.test;

import cn.gsxt.config.UserConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        User getUser = (User)context.getBean("getUser");
        System.out.println(getUser.getName());
    }
}
