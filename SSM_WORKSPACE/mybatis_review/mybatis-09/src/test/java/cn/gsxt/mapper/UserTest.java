package cn.gsxt.mapper;

import cn.gsxt.module.User;
import cn.gsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userById = mapper.findUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
}
