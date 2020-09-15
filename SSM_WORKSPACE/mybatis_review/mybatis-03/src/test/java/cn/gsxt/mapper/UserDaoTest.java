package cn.gsxt.mapper;

import cn.gsxt.module.User;
import cn.gsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test1(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();

    }


    //根据Id查询用户
    @Test
    public void test3(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(6);
        System.out.println(user);
        //关闭sqlSession
        sqlSession.close();

    }

    //根据Id修改用户
    @Test
    public void test4(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //模拟一个User对象
        User user = new User();
        user.setId(5);
//        user.setName("lyy123456789");
//        user.setPwd("123456789");
        mapper.updateUser(user);
        //关闭sqlSession
        sqlSession.close();

    }
}
