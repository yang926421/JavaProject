package cn.gsxt.test;

import cn.gsxt.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void test1() throws Exception {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //测试打印
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception {
        //模拟user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        int insert = sqlSession.insert("userMapper.save", user);
        //测试打印
//        System.out.println(userList);
        //默认jdbc的事务  事务默认是不提交的,需要手动去提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    //    修改操作
    @Test
    public void test3() throws Exception {
        //模拟user对象
        User user = new User();
        user.setId(3);
        user.setUsername("luccy");
        user.setPassword("123");
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行修改操作   需要传递id
        int update = sqlSession.update("userMapper.update", user);
        //默认jdbc的事务  事务默认是不提交的,需要手动去提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    //删除操作
    @Test
    public void test4() throws Exception {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行修改操作   需要传递id
        int delete = sqlSession.delete("userMapper.delete", 3);
        //默认jdbc的事务  事务默认是不提交的,更新操作需要手动去提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    //根据id查询一条数据
    @Test
    public void test5() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //想要获取sqlSession先要获取sqlSessionFactory要获取工厂就需要工厂构造器创建要使用工厂构造器创建需要传入流
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建sqlSession工厂
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取sqlSession连接对象
        SqlSession sqlSession = build.openSession();
        //执行数据库操作
        User user = sqlSession.selectOne("userMapper.findById", 3);
        System.out.println(user);
        //关闭连接
        sqlSession.close();
    }


    //根据多个字段查询
    @Test
    public void test6() throws Exception {
        //模拟user对象
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123");
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //想要获取sqlSession先要获取sqlSessionFactory要获取工厂就需要工厂构造器创建要使用工厂构造器创建需要传入流
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建sqlSession工厂
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取sqlSession连接对象
        SqlSession sqlSession = build.openSession();
        //执行数据库操作
        User user1 = sqlSession.selectOne("userMapper.findByUsernameAndPassword", user);
        System.out.println(user1);
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void test7() throws Exception {
        String username = "zhangsan";
        //获取
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //
        Object o = sqlSession.selectOne("userMapper.findByUsername", username);
        System.out.println((User) o);
    }

}
