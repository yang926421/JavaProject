package com.java.meiju;

/**
 * 目标类  枚举类的概述(面向对象的特殊类型)
 *
 *枚举类的作用?
 *  枚举用来做信息标志和信息分类.
 *枚举类的格式
    修饰符  enum 枚举名称{
    实例1名称, 实例2名称....;
 }
 枚举第一行罗列的必须是枚举名称
 源代码
 public enum Sex{
 BOY, GIRL
 }
 反编译后的枚举源代码
 public final class Sex extends java.lang.Enum<Sex> {
 public static final Sex BOY;
 public static final Sex GIRL;
 public static Sex[] values();
 public static Sex valueOf(java.lang.String);
 static {};
 }
 枚举类的特点
    1,枚举类是final修饰的,不能被继承
    2.枚举类默认继承了枚举类型 java.lang.Enum
    3.枚举类的第一行罗列的是枚举类的对象,而且是常量存储的.
    4.枚举类的第一行都是常量名称,默认存储了枚举对象
    5.枚举类的构造器默认是私有的
    6.枚举类相当于是多例设计模式
 小结:
    记住枚举的格式和特点
 作用:
    用常量做信息标志和信息分类,入参不受控制,入参太随性,无法严谨
 *
 * */

public class first_enum {
    public static void main(String[] args) {
        Sex s1 = Sex.BOY;
        System.out.println(s1);
        System.out.println(s1.ordinal()); //打印枚举对象的索引位置


    }
}

enum Sex{
    BOY, GIRL;
}