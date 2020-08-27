package 面向对象相关._01面向对象基础._02test;

public class Person {
    String name;
    int age;

    public void eat() {
        System.out.println(this.name + "吃饭呀");
    }

    public void sleep() {
        System.out.println(this.name + "睡觉");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
