package com.lyy.mysql._01JDBC基础;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;

import static java.lang.Class.forName;

/**
 java.sql.DriverManager类   管理一组jdbc驱动程序的基本服务
 DriverManager类下有个registerDriver静态方法
    向DriverManager注册给定驱动程序   参数是一个Driver接口  所以调用方法必须传递该接口的实现类对象
 Mysql驱动,也有个类实现Driver接口
    通过查看API文档,发现有个Driver类实现java.sql.Driver接口
    public class Driver extends NonRegisteringDriver implements java.sql.Driver
    类中有个空参构造器,可以直接创建对象






 */

public class JdbcRegister {
    public static void main(String[] args) throws Exception{
        //注册驱动  方式一  mysql提供的驱动中driver类下有个静态代码块  实现的就是注册驱动
        // 当我们new这个类的对象的时候就会自动执行静态代码块,所以不用再注册
//        DriverManager.registerDriver(new Driver());
        //方式二  newDriver()类对象 会自动执行静态代码块,所以还是不用再注册,
        // 这两种方法属于把代码写死了 只执行mysql驱动
//        new Driver();
        //方式三  只要将这个类的class加载到内存,这个类中的静态代码块就会被执行
        // 反射中的class.forName("com.jdbc.mysql.Driven")
        /**class.forName("com.jdbc.mysql.Driven");
        这句话的意思就是获取方法参数字符串代表的类对应的class类型的对象,优先把.class文件加载到内存中,再创建class类型的对象
         我们的需求就是想把这个class文件加载到内存中,让它执行代码块,就可以完成驱动的注册
         */
        Class.forName("com.mysql.jdbc.Driver");


    }
}
