package com.lyy.mysql._01JDBC基础;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DriverManager类下有一个静态方法,参数有三个
 *
 * @CallerSensitive public static Connection getConnection(String url,
 * String user, String password)
 * 试图建立到给定数据库的连接
 * 参数有三个
 * String url
 * 到数据库的链接地址  固定写法
 * jdbc:mysql://localhost:3306/数据库名称  localhost 如果是远程连接,换成远程连接的地址
 * String user
 * 用户名
 * String password
 * 用户密码
 * 返回值类型
 * java.sql.Connection 接口
 * 方法内部必然返回该接口的实现类对象
 */
public class JdbcGetConnectionDemo1 {
    public static void main(String[] args) throws Exception {
        //获得连接之前首先要注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        //定义数据库的连接地址
        String url = "jdbc:mysql://localhost:3306/jdbc_mysql1";
        String user = "root";
        String password = "123";
        //获得连接
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);  //com.mysql.jdbc.JDBC4Connection@25af5db5  是Connection接口的实现类对象

    }

}
