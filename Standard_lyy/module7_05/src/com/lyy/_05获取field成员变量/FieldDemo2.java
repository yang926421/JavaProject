package com.lyy._05获取field成员变量;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldDemo2 {
    /**
     反射获取成员变量 赋值或者取值
    Field的方法
        set(Object obj, Object Value) //给对象注入某个成员变量的值
        get()  获取对象的成员变量的值
        setAccessible(true)  暴力反射s设置为可以直接访问的私有类型的属性
        getType()   获取对象的类型 返回class对象
        getName()  获取对象的名称

     */
    @Test
    public void setField() throws Exception{
        Class c1 = Dog.class;
        //定位到name
        Field name1 = c1.getDeclaredField("name");
        //为这个成员变量赋值
        Dog taiDi = new Dog();
        name1.setAccessible(true);
        /**

         参数一  被赋值的对象
         参数二  该参数成员变量的值
         */
        name1.set(taiDi,"勇敢的");
        System.out.println(taiDi);

        //获取该成员变量的值
        String value = name1.get(taiDi) + "";
        System.out.println(value);

    }
}
