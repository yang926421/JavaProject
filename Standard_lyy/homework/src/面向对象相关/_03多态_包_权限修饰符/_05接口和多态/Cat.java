package 面向对象相关._03多态_包_权限修饰符._05接口和多态;

public class Cat extends Animal {
    public Cat() {
        super();
    }

    public Cat(String name, String weight) {
        super(name, weight);
    }

    @Override
    public void eat() {
        System.out.println("这是猫的方法 猫在吃");
    }

    public void catchMouse() {
        System.out.println("猫在抓老鼠");
    }
}
