package cn.gsxt.test;

import cn.gsxt.dao.UserMapper1;
import cn.gsxt.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {

//    private static Logger logger = LogManager.getLogger(MapperTest.class.getName());
    @Test
    public void test1() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig1.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        //模拟业务层传递过来的对象
//        User user = new User();
//        user.setUsername("zhangsan");
//        user.setPassword("123");
//        List<User> userList = mapper.findByCondition(user);
        //模拟ids的数据
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(1);
//        List<User> userList = mapper.findByIds(ids);
//        System.out.println(userList);


//模拟业务层传递过来的对象  带有birthday属性
        User user = new User();
        user.setUsername("ceshi");
        user.setPassword("123");
        user.setBirthday(new Date());
        //自定义类型转换器
        mapper.save(user);
        sqlSession.commit();
    }

    @Test
    public void test2() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig1.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);

        //自定义类型转换器查询
        User user = mapper.findById(5);
        System.out.println("user中类型转换存进去的birthday"+user.getBirthday());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig1.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        //设置分页的相关参数 当前页+每页显示的条数
        PageHelper.startPage(1,3);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println("查询的数据"+user);
        }
        //获得与分页相关的参数
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        System.out.println("当前页码"+userPageInfo.getPageNum());
        System.out.println(userPageInfo.getLastPage());
        System.out.println(userPageInfo.getFirstPage());
        System.out.println(userPageInfo.getNextPage());
        System.out.println("每页显示的条数"+userPageInfo.getPageSize());
        System.out.println(userPageInfo.getTotal());
        System.out.println(userPageInfo.getPages());
        sqlSession.commit();
        sqlSession.close();
    }
}
