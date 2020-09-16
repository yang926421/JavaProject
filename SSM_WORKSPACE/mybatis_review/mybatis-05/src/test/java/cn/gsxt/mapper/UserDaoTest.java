package cn.gsxt.mapper;

import cn.gsxt.module.User;
import cn.gsxt.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    //在日志中进行自定义 加输出语句
    Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test1(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    //注解根据id查询
    @Test
    public void test2(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

    }

    //注解根据id查询
    @Test
    public void test3(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(8);
        user.setName("lyyyyy");
        user.setMoney(50000);
        mapper.insert(user);
        sqlSession.close();

    }

    //注解根据id修改
    @Test
    public void test4(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(8);
        user.setName("lhhhhhy");
        user.setMoney(500);
        mapper.update(user);
        sqlSession.close();

    }

    //注解根据id删除
    @Test
    public void test5(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delete(7);
        sqlSession.close();

    }


    //配置好log4j进行测试
    @Test
    public void testLog4j(){
        logger.info("info:进入到了log4j自定义日志");
        logger.debug("debug:进入到了log4j自定义日志");
        logger.error("error:进入到了log4j自定义日志");
    }


}
