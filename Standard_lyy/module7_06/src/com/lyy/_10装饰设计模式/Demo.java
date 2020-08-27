package com.lyy._10装饰设计模式;

public class Demo {
    /**
     * 装饰模式
     * 装饰模式是指在不改变原类，动态的扩展一个类的功能，
     * 思想 创建一个新类 包装原始类  从而在新类中提升原始类的功能
     */
    public static void main(String[] args) {
        InputStream_demo is = new BufferInput_demo(new FileInputStream_demo());
        is.read();
        is.close();
    }
}
