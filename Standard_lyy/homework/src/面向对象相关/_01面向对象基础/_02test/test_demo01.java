package 面向对象相关._01面向对象基础._02test;

public class test_demo01 {
    public static void main(String[] args) {
        Teacher p1 = new Teacher();
        p1.age = 21;
        p1.name = "小秃头";
        p1.eat();
        p1.sleep();
        p1.beginClass();

        System.out.println("--------------");
        Coder c1 = new Coder();
        c1.age = 22;
        c1.name = "马化腾";
        c1.eat();
        c1.sleep();
        c1.KnockNode();

    }
}
