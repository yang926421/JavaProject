package com.lyy._05获取field成员变量;

import org.junit.Test;

import java.lang.reflect.Field;
/**
 反射的第一步是先得到Class类对象。

 1、Field getField(String name);
 根据成员变量名获得对应Field对象，只能获得public修饰
 2.Field getDeclaredField(String name);
 根据成员变量名获得对应Field对象，只要申明了就可以得到
 3.Field[] getFields();
 获得所有的成员变量对应的Field对象，只能获得public的
 4.Field[] getDeclaredFields();
 获得所有的成员变量对应的Field对象，只要申明了就可以得到
 小结：(重要)
 获取全部成员变量：getDeclaredFields
 获取某个成员变量：getDeclaredField

 */

public class FieldDemo1 {
    //获取到成员变量
    @Test
    public void getField() throws Exception{
        //获取到class类
        Class c1 = Dog.class;
        //定位到成员变量
        Field[] fields = c1.getFields(); //获取到全部的成员变量 只能获取到public修饰的
        Field[]  fields1 = c1.getDeclaredFields();// 可以获取到全部的只要你定义的成员变量

        Field field = c1.getField("age"); //根据参数获取成员变量 只能获取到public修饰的
        Field field1 = c1.getDeclaredField("color");//获取到任意的

    }
}
