package cn.gsxt.test;

import cn.gsxt.mapper.UserMapper;
import cn.gsxt.module.User;
import cn.gsxt.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.Reader;
import java.util.List;
import java.util.Properties;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getAllUsers();

//        List<User> allUsers = userMapper.getAllUsers();
//        for (User allUser : allUsers) {
//            System.out.println(allUser);
//        }

    }
}
