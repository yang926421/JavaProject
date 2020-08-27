package com.lyy._08反射的作用在哪里;

public class ReflectDemo1 {
    /**
     * 反射的作用
     * 可以在运行时得到一个类的全部成分然后操作
     * 可以破坏封装性
     * 也可以破坏泛型的约束性
     * <p>
     * 更重要的用途是适合做java的高级框架  基本上主流的框架都会基于反射设计一些通用的技术功能
     * <p>
     * Mybatis(自己的类 模拟实现框架的作用)
     * 给一个任何对象数据都可以解析字段并把对应的数据保存起来
     * 小结：
     * 反射适合做通用技术框架的底层实现，在框架的底层源码中我们经常看到反射的影子!!
     */
    public static void main(String[] args) throws Exception {
        Student s1 = new Student(1, "赵敏", 26, '女', "光明顶", "110");
        Mybatis.save(s1);

        Pig peiQi = new Pig("佩奇", 500.0, "粉色", "小红", "母猪");
        Mybatis.save(peiQi);
    }

}
