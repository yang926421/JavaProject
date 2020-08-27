package com.lyy._04反射获取Constructor构造器;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class construction_demo1 {
    /**
     * 反射获取Constructor构造器对象
     * <p>
     * 反射的第一步永远是得到Class类对象(class文件)
     * 反射中获取Class类型构造器提供了api
     * <p>
     * 1.getConstructor(参数)   根据参数匹配获取单个构造器,只能获取到public修饰的
     * 2.getDeclaredConstructor()   根据参数匹配构造器 可以获取到任何构造器,,不用考虑修饰符
     * 3.getConstructors()  获取所有的构造器对象,只能获取到所有public修饰的构造器
     * 4.getDeclaredConstructors()  只要你写的构造器 都可以获取到
     */
    //获取到全部的构造器 只能拿到public修饰的
    @Test
    public void getConstructors() {
        //反射第一步都是先获取到class类对象
        Class c1 = Student.class;
        //根据class类对象获取到构造器
        Constructor[] cons = c1.getConstructors();
        //遍历这些构造器
        for (Constructor con : cons) {
            System.out.println(con.getName() + "======>" + con.getParameterCount());
        }
    }

    @Test
    public void getDeclaredConstructors() {
        //
        Class c1 = Student.class;
        Constructor[] cons = c1.getDeclaredConstructors();//只要你敢写  我就能拿到你的构造器
        for (Constructor con : cons) {
            System.out.println(con.getName() + "=====>" + con.getParameterCount());
        }
    }

    @Test
    public void get_onstructor() throws Exception {
        Class c1 = Student.class;
        //因为只能拿到public修饰的,所以无参构造器会报错
//        Constructor[]  cons = c1.getConstructor();
        // /可以拿到public修饰的
        Constructor con1 = c1.getConstructor(String.class, int.class);
        //

//        c1.getDeclaredConstructor()  可以拿到任意的构造器,哪怕不是public修饰的
        // 获取有参数的
        Constructor con_de = c1.getDeclaredConstructor(String.class, int.class);
    }

}
