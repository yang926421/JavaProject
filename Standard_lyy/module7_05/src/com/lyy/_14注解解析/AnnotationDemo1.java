package com.lyy._14注解解析;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationDemo1 {
    /**
     * 注解的解析
     * 经常会需要知道一个类的成分s上面有哪些注解，注解有哪些属性数据，都需要用到注解的解析
     * AnnotatedElement  注解类型  是所有注解的父类
     * 2.AnnotatedElement  该接口定义了与注解解析相关的方法
     * <p>
     * 所有的类成分Class, Method , Field , Constructor:都实现了AnnotatedElement接口
     * 他们都拥有解析注解的能力：
     * <p>
     * 解析注解数据的原理
     * 注解在哪个成分上 我们就先拿哪个成分对象
     * 比如注解作用成员方法，则需要获取该成员方法对应的method对象，再拿注解
     * 比如注解作用在类上，则要该类的Class对象，再来拿上面的注解
     * 比如注解作用在成员变量上，则要获得该成员变量对应的Field对象，再来拿上面的注解
     */
    @Test
    public void parseClass() throws Exception {
        //注解在类上，我们就先拿到这个class类对象
        Class c1 = BookStore.class;
        //获取类上的注解
//        c1.getDeclaredAnnotations()
        //判断当前对象是否使用了注解
        if (c1.isAnnotationPresent(Book.class)) {
            //获取这个注解对象
            Book book = (Book) c1.getDeclaredAnnotation(Book.class);
            //可以获取到注解的属性
            System.out.println(book.value());
        }
    }

    @Test
    public void parseMethods() throws Exception {
        //获取到class类对象
        Class c1 = BookStore.class;
        //定位到方法对象
        Method method = c1.getDeclaredMethod("run");
        //3判断方法是否使用了注解
        if (method.isAnnotationPresent(Book.class)) {
            Book book = (Book) method.getDeclaredAnnotation(Book.class);
            System.out.println(book.authors());
        }
    }


}

@Book(value = "《mysql从删库到跑路》", price = 99.2, authors = {"ly", "ht"})
class BookStore {
    @Book(value = "《mysql从删库到跑路再回来》", price = 99.6, authors = {"ly1", "ht"})
    public void run() {

    }

}


@Target({ElementType.METHOD, ElementType.TYPE}) //在类和方法中使用
@Retention(RetentionPolicy.RUNTIME)
        //注解永久存活
@interface Book {
    String value();

    double price();

    String[] authors();
}