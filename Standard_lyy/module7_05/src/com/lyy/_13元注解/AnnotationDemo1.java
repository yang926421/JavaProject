package com.lyy._13元注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 元注解是由sun公司提供的，用在自定义注解上的注解    元注解是注解自定义注解的

 元注解有两个
 @Target:约束自定义注解只能在哪里使用
    默认可以在类，方法构造器，成员变量使用

 @Retention申明注解的生命周期
    申明注解的作用范围 编译时 运行时

 @Target
    作用 用来标识注解的使用位置 如果没有使用该注解，则自定义注解可以使用在任何位置
    可使用的值定义在ElementType枚举类中，
        Type  类 接口
        Field  成员变量
        Method 成员方法
        PARAMETER  方法参数
        constructor  构造器
        Local_variable局部变量

 @Retention
    作用  用来标识注解的生命周期
        常使用的
    source作用在源码阶段。生成的字节码文件不可用
     class 作用在源码字节码文件 运行时不可用
    RUNTIME  注解作用在源码阶段，字节码文件阶段 运行阶段




 */
//@Book(name = "hht")  报错 因为只能注解在方法上
public class AnnotationDemo1 {
    @Book(name = "ly")
    public static void main(String[] args) {

    }
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) //申明注解从写代码到运行一直存在
@interface Book{
    String name();
}
