package cn.gsxt.service;

import cn.gsxt.mapper.UserMapper;
//import cn.gsxt.dao.impl.UserMapperImpl;
import cn.gsxt.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class UserService {
    public static void main(String[] args) throws Exception {
//        //手动创建dao层
//        UserMapper userMapper = new UserMapperImpl();
//        List<User> userList = userMapper.findAll();
//        System.out.println(userList);


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = mapper.findAll();
        //根据id单个查询
        User user = mapper.findById(1);
        System.out.println(user);
    }

}
