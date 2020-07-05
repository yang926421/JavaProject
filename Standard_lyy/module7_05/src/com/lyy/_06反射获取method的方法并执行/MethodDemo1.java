package com.lyy._06反射获取method的方法并执行;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodDemo1 {
    /**
     获取method的方法
     1、Method getMethod(String name,Class...args);
     根据方法名和参数类型获得对应的方法对象，只能获得public的

     2、Method getDeclaredMethod(String name,Class...args);
     根据方法名和参数类型获得对应的方法对象，包括private的

     3、Method[] getMethods();
     获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的

     4、Method[] getDeclaredMethods();
     获得类中的所有成员方法对象，返回数组,只获得本类申明的方法。
     */
    
    @Test
    public void getMethod() throws Exception{
        //获取到class类对象
        Class c1 = Dog.class;
        //定位到类中的所有method方法
        Method[] methods = c1.getDeclaredMethods();//可以获取到声明的全部的
        for (Method method : methods) {
            System.out.println(method.getName()+"=====>"+method.getParameterCount());
        }
    }

    @Test
    public void getMethod1() throws Exception{
        //获取到class类对象
        Class c1 = Dog.class;
        //定位到单个类方法
        Method run = c1.getDeclaredMethod("run");
        //触发方法执行
        Dog dog = new Dog();
        Object rs = run.invoke(dog); //触发dog的run方法执行
        System.out.println(rs); //如果没有返回值则返回NULL


        /**
         获取有参数的且是私有的方法
         参数一  方法名称
         参数二  方法需要的入参值
         */
        Method eat = c1.getDeclaredMethod("eat", String.class);
        //因为是私有的所以暴力反射
        eat.setAccessible(true);
        /**
         方法的调用
         参数一   被触发方法所在的对象
         参数二   方法需要的入参值
         */
        Object rs1 = eat.invoke(dog, "肉");
        System.out.println(rs1);
    }

}
