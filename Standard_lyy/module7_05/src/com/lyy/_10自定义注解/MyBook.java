package com.lyy._10自定义注解;
/**
 之前使用的注解都是别人定义好的

 自定义注解的格式
    修饰符 @interface 注解名{
        //注解属性
 }
 */
@Book
@MyTest
public class MyBook {
    private MyBook(){}
    @MyTest
    public static void main(String[] args) {
        int age = 12;
    }
}

//注解的格式
@interface  Book{

}
@interface MyTest{}
