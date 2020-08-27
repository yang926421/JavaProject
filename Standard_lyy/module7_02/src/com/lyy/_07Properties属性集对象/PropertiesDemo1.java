package com.lyy._07Properties属性集对象;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Properties的概述和使用(框架底层使用,保存数据到属性文件)
 * <p>
 * Properties :属性集对象
 * 其实既是一个map集合 也就是一个键值对集合,但是我们一般不把它当键值对集合来使用,因为有
 * Hashmap
 * Properties的核心作用
 * Properties代表的是一个属性文件,可以把键值对数据存放到一个属性文件中去
 * 属性问价  后缀是.properties的文件,里面内容都是key=value
 * 大型框架技术中，属性文件都是很重要的系统配置文件。
 * users.properties
 * admin=123456
 * dlei=dlei
 * <p>
 * <p>
 * 需求
 * 使用Properties对象生成一个属性文件,里面存入用户名和密码信息
 * Properties的方法
 */
public class PropertiesDemo1 {
    public static void main(String[] args) throws Exception {
        //创建一个属性集对象
        Properties properties = new Properties();
        properties.setProperty("admin", "123456");
        properties.setProperty("deli", "123654");
        System.out.println(properties);
        //把属性集对象数据保存到文件中去
        OutputStream OS = new FileOutputStream("module7_02/src/users.properties");
        /**

         */
        properties.store(OS, "我非常高兴的保存了用户数据到指定文件只去");
    }
}
