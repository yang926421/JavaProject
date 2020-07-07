package com.lyy._09工厂设计模式;

public class Dog extends Animal{
    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void run() {
        System.out.println("🐶是跑的很快的。");
    }
}
