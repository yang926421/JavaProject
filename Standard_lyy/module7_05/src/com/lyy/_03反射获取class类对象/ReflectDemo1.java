package com.lyy._03反射获取class类对象;
/**
 目标   反射获取class类对象

    引入 反射是通过先得到编译之后的class类对象,字节码文件
        然后才可以得到类中的全部成分 进行一些功能设计

 反射为一个类的全部成分都设计了一个类型来代表这个对象
    Class 字节码文件的类型
    Constructor  构造器的类型
    Field   成员方法的类型
    Method  方法的类型

 反射技术的第一步永远是先得到Class类对象  有三种方式获取
    (1)  类名.class
    (2) 通过类的对象.getClass方法
    (3) Class.forName("类的权限名")
            --public static Class<?> forName(String className)

    Class 类下的方法
        String getSimpleName();  获取类名字符串 类名
        getName()   获得类全名  包名+类名








 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception{
        //获取类的class文件对象
        Class c1 = Student.class;
        System.out.println(c1);

        // 通过对象获取类的class文件对象
        Student s1 = new Student();
        Class C2 = s1.getClass();
        //  获取类名本身
        System.out.println(C2.getSimpleName());
        //获取全限名   全路径限制名
        System.out.println(c1.getName());

        //第三种方式
        Class c3 = Class.forName("com.lyy._03反射获取class类对象.Student");
        System.out.println(c3);
    }

}
