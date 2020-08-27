package com.lyy.mysql._01JDBC基础;

import org.junit.Test;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
 * <p>
 * <p>
 * <p>
 * 不管是什么参数都可以看做Object
 * setObject(index, Object value);
 * 给sql语句的index位置的?号赋值为value
 * 同理 还有很多设置方法
 * 3.执行sql语句的抽象方法
 * executeUpdate()
 * 在此 PreparedStatement 对象中执行 SQL 语句，该语句必须是一个 SQL 数据操作语言
 * （Data Manipulation Language，DML）语句，
 * 比如 INSERT、UPDATE 或 DELETE 语句；或者是无返回内容的 SQL 语句，比如 DDL 语句。
 * public abstract int executeUpdate()  抽象方法  只能执行增删改的操作  返回数据是int
 * 意思是操作了几行数据
 * 此方法不需要给sql语句作为执行参数,因为创建prepareStatement对象的时候已经给过sql语句参数了
 * <p>
 * <p>
 * 创建表 sql语句
 * create table users(
 * uid int primary key,
 * username varchar(32),
 * password varchar(32));
 */
/**
 创建表 sql语句
 create table users(
 uid int primary key,
 username varchar(32),
 password varchar(32));
 */

/**
 有sql语句的jdbc的操作步骤
 1.注册驱动
 2.创建连接
 3.定义sql语句参数使用?代替
 4.获取执行sql语句的PreparedStatement对象
 5.给sql语句的?赋值
 6.执行sql语句,获取结果]
 7.处理结果
 8.关闭资源
 */
public class jdbcStatement {
    //给数据库添加一条数据
    @Test
    public void addOne() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/jdbc_mysql1";
        String user = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, user, password);
        //3.定义sql语句参数使用?代替
        String sql = "insert into users(uid, username, password) values(?, ? ,?)";
        //4 获取执行sql语句的PreparedStatement对象
        PreparedStatement pstmt = con.prepareStatement(sql);
        // 5.给sql语句中添加数据
        pstmt.setInt(1, 1);
        pstmt.setString(2, "admin");
        pstmt.setString(3, "123456");
        //6.执行sql语句 获取结果
        int result = pstmt.executeUpdate();
        //处理结果
        if (result > 0) {
            System.out.println("添加数据成功");
        } else System.out.println("添加数据失败");

        //关闭资源
        con.close();
        pstmt.close();


    }

    //给数据库修改一条数据
    @Test
    public void updateOne() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 连接数据库
        String url = "jdbc:mysql://localhost:3306/jdbc_mysql1";
        String user = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, user, password);
        //定义sql语句
        String sql = "update users set username = ?, password = ? where uid =?";
        //获取到执行sql语句的PreparedStatement对象
        PreparedStatement pstmt = con.prepareStatement(sql);
        //给sql语句设置值
        pstmt.setString(1, "root");
        pstmt.setString(2, "1234");
        pstmt.setInt(3, 1);
        //执行sql语句获取到结果
        int result = pstmt.executeUpdate();
        //判断是否成功
        if (result > 0) {
            System.out.println("更改数据操作成功");
        } else System.out.println("更改数据操作失败");
        // 关闭资源
        con.close();
        pstmt.close();
    }

    @Test
    public void deleteOne() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/jdbc_mysql1";
        String user = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, user, password);
        // 编写sql语句
        String sql = "delete from users where uid = ?";
        //获取执行sql语句的PrepareStatement对象
        PreparedStatement pstmt = con.prepareStatement(sql);
        //给sql语句设置值
        pstmt.setInt(1, 1);
        // 运行sql语句
        int result = pstmt.executeUpdate();
        if (result > 0) System.out.println("删除成功");
        else System.out.println("删除失败");
        //关闭资源
        con.close();
        pstmt.close();


    }
}
