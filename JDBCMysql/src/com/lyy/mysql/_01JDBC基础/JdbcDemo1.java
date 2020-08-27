package com.lyy.mysql._01JDBC基础;

public class JdbcDemo1 {
    /**
     jdbc开发步骤
     1.注册驱动
     告诉jvm我们使用的是什么数据库
     导入包(将mysql提供的针对java操作数据库的一些个类/接口导入到模块中)
     2.获得连接
     获取java连接到数据库的connection对象
     3.获得执行sql语句的对象
     通过连接数据库的connection对象 创建操作数据库的statement对象
     4.执行sql语句,并返回结果
     执行SQL语句的statement对象执行增删改的操作,获取结果,int数字代表影响的行数
     执行SQL语句的statement对象执行查询的操作,获取结果,int数字代表影响的行数
     5.处理结果
     针对增删改的操作,返回的是int数字,不需要进行处理
     针对查询的操作,返回的结果是resultSet对象,需要处理.遍历输出或者封装对象
     6.关闭资源
     连接对象(Connection)需要释放
     执行sql语句的statement对象
     resultSet对象
     都需要释放资源

     */

}
