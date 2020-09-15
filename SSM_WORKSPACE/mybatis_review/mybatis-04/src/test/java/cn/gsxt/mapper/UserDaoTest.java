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
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();

    }

    // 在分页组件的加持下
    @Test
    public void test2(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1, 2);
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

    //配置好log4j进行测试
    @Test
    public void testLog4j(){
        logger.info("info:进入到了log4j自定义日志");
        logger.debug("debug:进入到了log4j自定义日志");
        logger.error("error:进入到了log4j自定义日志");
    }

    //使用limit分页查询数据
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("startIndex",0);
        hashMap.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(hashMap);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }


}
