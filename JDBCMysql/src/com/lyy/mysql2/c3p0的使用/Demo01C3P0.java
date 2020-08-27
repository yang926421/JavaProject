package com.lyy.mysql2.c3p0的使用;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

public class Demo01C3P0 {
    public static void main(String[] args) throws Exception {
        //创建C3p0连接池对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //设置驱动
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        //连接数据库
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_mysql1");
        cpds.setUser("root");
        cpds.setPassword("123");
        //获取连接对象
        Connection con = cpds.getConnection();
        System.out.println(con);


    }
}
