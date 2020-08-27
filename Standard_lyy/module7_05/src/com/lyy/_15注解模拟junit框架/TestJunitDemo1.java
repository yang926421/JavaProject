package com.lyy._15注解模拟junit框架;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 目标：自定义注解模拟写一个Junit框架的基本使用。
 * <p>
 * 需求：定义若干个方法，只要加了MyTest注解，
 * 就可以被自动触发执行。
 * <p>
 * 分析：
 * （1）定义一个自定义注解MyTest.
 * -- 只能注解方法。
 * -- 存活范围一直都在。
 * （2）定义若干个方法，只要有@MyTest注解的方法就能被触发执行！！
 * 没有这个注解的方法不能执行！！
 * 小结：
 * 注解和反射可以配合解决一些框架思想
 * 注解可以实现标记的成分做特殊处理!!
 */
public class TestJunitDemo1 {
    @Test1
    public void run() {
        System.out.println("我是run");
    }

    public void run1() {
        System.out.println("我是run2");
    }

    @Test1
    public void run3() {
        System.out.println("我是run3");
    }

    public static void main(String[] args) throws Exception {
        TestJunitDemo1 t = new TestJunitDemo1();
        //模拟测试类的启动按钮，实现有注解的都可以执行
        Class c1 = t.getClass();
        //获取类中的全部对象方法
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test1.class)) {
                //触发此方法执行
                method.invoke(t);  //反射  fangFa.invoke(类对象)
            }
        }
    }


}


//自定义注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test1 {

}