package com.lyy._02反射的概述;

public class ReflectDemo1 {
    /**
     反射的概念
     反射,注解,泛型是java的高级技术,是以后框架中底层原理必须使用的技术
     反射是指对于任何一个类,在"运行的时候"都可以直接得到这个类的全部成分
     在运行时,可以直接得到这个类的构造器对象(Constructor)
     在运行时,可以直接得到这个类的成员变量对象(Field)
     在运行时,可以直接得到这个类的成员方法对象(Method)

     反射的核心思想
     得到编译后的class文件对象
     反射提供了一个class类型,就是可以得到编译以后的class文件对象
     helloWorld.java  ->javac-->helloWorld.class

     Class c = helloWorld.class


     注意  反射是工作在运行时的技术,因为只有运行之后才会有class类对象

     小结
     反射的核心思想  就是得到编译之后的class文件对象
     反射是在运行时获取类的字节码文件对象,然后可以解析类中的全部成分



     */
}
