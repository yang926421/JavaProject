package com.java.lambda_test;
/**

 1.匿名内部类是一个没有名字的内部类
 2.匿名内部类一旦写出来,就会立即创建一个匿名内部类对象返回
 3.匿名内部类的对象的类型相当于当前new的那个类型的子类类型


 * */

public class Anonymous {
    private int age;

    public Anonymous(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        //原本的方式
//        Animal A1 = new cat();
//        A1.run();
//        A1.test();
        // 使用抽象类的方式
        Animal a1 = new Animal() {
            @Override
            public void run() {
                System.out.println("小猫在匿名内部类重写的方法跑啊");
            }
        };
        a1.run();
        a1.test();
    }

    @Override
    public String toString() {
        return "Anonymous{" +
                "age=" + age +
                '}';
    }
}

class cat extends Animal{
    //重写抽象方法
    @Override
    public void run() {
        System.out.println("小猫在跑啊");
    }
}

abstract class Animal{
    //定义一个抽象方法
    public abstract void run();

    public void test(){
        System.out.println("抽象类中的方法");
    }
}
