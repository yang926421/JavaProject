package cn.gsxt.test;

import cn.gsxt.domain.User;
import cn.gsxt.mapper.UserMapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import sun.nio.cs.US_ASCII;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private  UserMapper mapper;
    @Before
    public void before() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test1(){
        User user = new User();
        user.setUsername("lyy");
        user.setPassword("123");

        mapper.save(user);
    }


    @Test
    public void test2(){
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test3(){
        User user = mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void test4(){
        User user = new User();
        user.setId(3);
        user.setUsername("zhangsan");
        user.setPassword("123");
        mapper.update(user);
    }

    @Test
    public void test5(){
        mapper.delete(4);
    }

    @Test
    //一对多的查询
    public void test(){
        List<User> userAndOrder = mapper.findUserAndOrder();
        for (User user : userAndOrder) {
            System.out.println(user);
        }
    }


    @Test
    //一对多的查询
    public void test6(){
        List<User> userAndRole = mapper.findUserAndRole();
        for (User user : userAndRole) {
            System.out.println(user);
        }
    }
}
