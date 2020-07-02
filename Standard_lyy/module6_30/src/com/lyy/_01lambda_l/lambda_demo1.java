package com.lyy._01lambda_l;
/**
 lambda表达式1.8开始的新技术,是一种代码的新语法,特殊写法,核心是为了简化匿名内部类的代码写法
格式
    (匿名内部类被重写方法的形参列表) ->{
    重写的代码体
 }
lambda表达式使用前提
    并不能简化所有匿名内部类的写法,只能简化接口中只有一个抽象方法的匿名内部类
 只能简化函数式接口的匿名内部类写法,首先只能是接口,其次接口中只能有一个抽象方法
 函数式接口的概念
    接口中只有一个抽象方法 lambda表达式只能简化函数式接口的匿名内部类
 */
public class lambda_demo1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"在运行");
            }
        };
        //不是函数式接口的匿名内部类  不能lambda
//        Thread t2 = () ->{
//            System.out.println(123);
//        };
    }
}


