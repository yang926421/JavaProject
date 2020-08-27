package com.lyy._09工厂设计模式;

import org.junit.Test;

//定义一个抽象类
public abstract class Animal {
    public void eat() {
        System.out.println("卧槽");
    }

    public abstract void run();
}
