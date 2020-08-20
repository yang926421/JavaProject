package cn.gsxt.test;

import cn.gsxt.domain.User;
import cn.gsxt.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sun.nio.cs.US_ASCII;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {


    @Test
    public void test() throws Exception{
        //使用Mybatis获取流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMybatisConfig.xml");
        //获取sqlSessionFactory创造器
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //使用分页组件
        PageHelper.startPage(1,3);
        //使用sqlSession获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
//        System.out.println(userList);
    }

    @Test
    public void test1() throws Exception{
        //使用Mybatis获取流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMybatisConfig.xml");
        //获取sqlSessionFactory创造器
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        User user1 = mapper.findByUsernameAndPassword(user);
        System.out.println(user1);

    }

    @Test
    public void test2() throws Exception{
        //使用Mybatis获取流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMybatisConfig.xml");
        //获取sqlSessionFactory创造器
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> users = mapper.findByIds(ids);
        System.out.println(users);

    }
}
