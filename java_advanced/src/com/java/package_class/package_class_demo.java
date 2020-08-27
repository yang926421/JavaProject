package com.java.package_class;

/**
 * 八种基本数据类型
 * 整数类型
 * 整数类型    int  byte  short  long
 * 浮点类型 float  double
 * 字符型 char
 * 布尔型 boolean
 * 包装类(引用数据类型)
 * Integer Byte Short Long
 * Float  Double
 * Char
 * Boolean
 * Java中的基本数据类型没有方法和属性，而包装类就是为了让这些拥有方法和属性，实现对象化交互。
 */
public class package_class_demo {
    public static void main(String[] args) {
        System.out.println("基本数据类型和引用数据类型");
//        1.自动装箱  可以把基本数据类型的值或者变量赋值给包装类
        int a = 1;
        Integer A = a;
        // 自动拆箱  将引用数据类型的变量赋值给基本数据类型
        Integer c = 100;
        int c1 = c;
        // 引用数据类型的默认值可以为null
        Integer d1 = null;
//        int d = null;  会报错

//        手工装箱
        Integer I1 = Integer.valueOf(12);


    }
}
