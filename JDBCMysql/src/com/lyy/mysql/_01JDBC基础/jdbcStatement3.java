package com.lyy.mysql._01JDBC基础;

import org.junit.Test;
import utlis.JDBCUtilsFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 1. 注册驱动
 * 2.获得mysql连接
 * 3. 获得执行sql语句的statement对象
 * Connection接口下有一个方法
 * 获取执行sql语句的对象的api介绍
 * 1. public abstract PreparedStatement prepareStatement(String url)
 * 创建一个PreparedStatement对象来将参数化的sql语句发送到数据库
 * 参数  String类型的sql语句
 * sql语句中的参数可以使用?来代替   ?的index值从1开始 给sql语句的?设置值的时候需要用到
 * 返回值  类型
 * java.sql.PreparedStatement 接口  方法内部必然返回这个接口的实现类对象
 * 2.PreparedStatement接口中有很多方法用来给sql语句赋值的抽象方法'
 * 1.setInt(int parameterIndex, int x)
 * 将SQL语句中指定参数(index位置处)设置为 Java int 值。
 * 2.setString(int parameterIndex, String x)
 * 将SQL语句中指定参数(index位置处)设置为 Java String 值。
 * 不管是什么参数都可以看做Object
 * setObject(index, Object value);
 * 给sql语句的index位置的?号赋值为value
 * 同理 还有很多设置方法
 * 3.执行sql语句的抽象方法
 * executeQuery()
 * 在此 PreparedStatement 对象中执行 SQL 语句，只能执行查询语句,返回的对象是一个结果集，
 * public abstract ResultSet executeQuery()  抽象方法  返回值类型也是一个接口
 * java.sql.ResultSet   上面这个方法内部也要返回一个实现类对象
 * 此方法也不需要给sql语句作为执行参数,因为创建prepareStatement对象的时候已经给过sql语句参数了
 * 4 java.sql.ResultSet  这个接口板有一些抽象方法
 * public abstract Boolean next(); 判断是否有下一行数据,返回true表示有,返回false表示没有
 * public abstract int getInt(int index) ; 获取方法参数index编号对应的指定列的int数字
 * public abstract int getString(int index) ; 获取方法参数index编号对应的指定列的String数据
 * public abstract String getInt(String name) ; 获取方法参数列名为name对应的指定列的int数字
 * public abstract String getString(String name) ; 获取方法参数列名为name对应的指定列的String数据
 * <p>
 * <p>
 * 只用记下边两个
 * public abstract Object getObject(int index) 获取参数名为 int 的index列对应的Object数据
 * public abstract Object getObject(String name) 获取参数列名为name的指定列的Object数据(最建议使用这个)
 * Object uid = ResultSet.getObject("uid")
 * <p>
 * <p>
 * 创建表 sql语句
 * create table users(
 * uid int primary key,
 * username varchar(32),
 * password varchar(32));
 * <p>
 * 准备数据
 * insert into users(uid, username, password) values(1, 'admin','123456');
 * insert into users(uid, username, password) values(2, 'admin2','123456');
 * insert into users(uid, username, password) values(3, 'admin3','123456');
 */
/**
 创建表 sql语句
 create table users(
 uid int primary key,
 username varchar(32),
 password varchar(32));

 准备数据
 insert into users(uid, username, password) values(1, 'admin','123456');
 insert into users(uid, username, password) values(2, 'admin2','123456');
 insert into users(uid, username, password) values(3, 'admin3','123456');
 */

/**
 有sql语句的jdbc的操作步骤
 1.注册驱动
 2.创建连接
 3.定义sql语句参数使用?代替
 4.获取执行sql语句的PreparedStatement对象
 5.给sql语句的?赋值
 6.执行sql语句,获取结果集
 7.处理结果
 8.关闭资源
 */
public class jdbcStatement3 {
    //给数据库添加一条数据
    @Test
    public void queryOne() throws Exception {
        Connection con = JDBCUtilsFinal.getConnection();
        //准备sql语句
        String sql = "select * from users where uid = ?";
        //获取执行sql语句的对象
        PreparedStatement pstmt = con.prepareStatement(sql);
        //给sql语句的?添加值
        pstmt.setInt(1, 1);
        //获取执行的结果集
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            System.out.println("查询到这条数据了");
            int uid = resultSet.getInt(1);
            //根据列名查询到第二列的值
            String username = resultSet.getString("username");
            Object password1 = resultSet.getObject("password");
            System.out.println(uid);
            System.out.println(username);
            System.out.println(password1);
        } else System.out.println("没有查询到数据");

        //关闭资源
        con.close();
        pstmt.close();
        resultSet.close();

    }

    //
    @Test
    public void queryAll() throws Exception {
        //1.注册驱动
        Connection con = JDBCUtilsFinal.getConnection();
        //准备sql语句
        String sql = "select * from users";
        //获取执行sql语句的对象
        PreparedStatement pstmt = con.prepareStatement(sql);
        //sql语句 没有问号 不用赋值
        //获取执行的结果集
        ResultSet resultSet = pstmt.executeQuery();
        System.out.println("查询到数据了");
        while (resultSet.next()) {
            int uid = resultSet.getInt(1);
            //根据列名查询到第二列的值
            String username = resultSet.getString("username");
            Object password2 = resultSet.getObject("password");
            System.out.println(uid);
            System.out.println(username);
            System.out.println(password2);
        }

        //关闭资源
        con.close();
        pstmt.close();
        resultSet.close();


    }
}
