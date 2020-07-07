package com.lyy._09工厂设计模式;

public class FactoryPattern {
    //生产对象的方法 工厂方法
    public static Animal createAnimal(){
//        Dog dog = new Dog();
//        return dog;
        return new Cat();

    }
}
