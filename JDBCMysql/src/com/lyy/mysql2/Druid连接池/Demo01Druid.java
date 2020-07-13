package com.lyy.mysql2.Druid连接池;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.util.ResourceBundle;

public class Demo01Druid {
    public static void main(String[] args) throws Exception{
        Properties pros = new Properties();
        InputStream is = Demo01Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        //把配置文件信息加载到properties集合对象中
        pros.load(is);
        //        ResourceBundle resourceBundle = ResourceBundle.getBundle("druid.properties");
        DataSource druidDataSource = DruidDataSourceFactory.createDataSource(pros);
        //druidDataSource连接池对象来获取连接
        Connection con = druidDataSource.getConnection();
        System.out.println(con);


    }
}
