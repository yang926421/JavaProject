package com.lyy._04反射获取Constructor构造器;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ConstructorDemo2 {
    /**
     * 反射获取到Constructor构造器,然后通过这个构造器初识化对象
     * 反射获取class中的构造器对象Constructor的作用
     * 也是初始化并得到类的一个对象返回
     * Constructor的API
     * 1.newInstance(Object initargs)
     * 创建对象,注入构造器需要的数据
     * 2.void setAccessible(true)
     * 修改访问权限,true代表暴力攻破权限,false表示保留不可访问权限
     */
    @Test
    public void createObj() throws Exception {
        //1反射第一步是得到Class类对象
        Class c1 = Student.class;
        //定位无构造构造器对象
        Constructor con = c1.getDeclaredConstructor();
        // 因为是私有的  暴力打开私有构造器的访问权限
        con.setAccessible(true);
        //通过无参构造器初始化对象返回
        Student swk = (Student) con.newInstance();
        System.out.println(swk);
    }

    @Test
    public void createObj2() throws Exception {
        //获取到class类对象
        Class c = Student.class;
        //定位有参构造器
        Constructor con = c.getDeclaredConstructor(String.class, int.class);
        //通过有参构造器初始化对象返回
        Student swk1 = (Student) con.newInstance("孙悟空", 1000);
        System.out.println(swk1);
    }


}
