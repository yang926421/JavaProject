package com.lyy.mysql2.c3p0配置文件连接;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * 通过配置文件读取C3p的连接对象 只需要把文件放在指定路径下  不需要自己去读取
 * 1.java硬编码方式 也就是自己去set赋值
 * 2.读取配置文件  src/c3p0.properties 必须放在src下
 * 3.读取配置文件   src/c3p0-config.xml
 * 这三种方式的优先级
 * 1.java硬编码的方式
 * 2.xml文件
 * 3.properties文件
 */
public class Demo01C3P0 {
    public static void main(String[] args) throws Exception {
        //创建C3p0连接池对象  会去src下读取配置文件
        //这样的坏处是每次创建连接的时候 都会来创建连接池对象  所以需要封装下
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //如果是有配置文件  然后又进行java硬编码set设置  name之前的配置文件就作废
        //获取连接对象
        Connection con = cpds.getConnection();
        System.out.println(con);


    }
}
