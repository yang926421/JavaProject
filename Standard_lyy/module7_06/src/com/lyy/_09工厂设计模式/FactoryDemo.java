package com.lyy._09工厂设计模式;

/**
 工厂设计模式
    工厂设计模式是Java中最常用的设计模式之一
 这种类型的设计模式属于创建型模式，提供了一种创建对象的方式
 创建类对象  可以new 对象的形式创建 工厂模式也可以
 工厂设计模式的作用
    1.对象通过工厂的方法创建返回，工厂的方法可以为该对象进行加工和数据注入
    2.可以实现类与类之间的解耦操作
 */
public class FactoryDemo {
    public static void main(String[] args) {
        Animal a = FactoryPattern.createAnimal();
        a.run();
    }
}
