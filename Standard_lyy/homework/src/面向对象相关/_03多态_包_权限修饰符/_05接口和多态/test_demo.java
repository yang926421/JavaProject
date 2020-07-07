package 面向对象相关._03多态_包_权限修饰符._05接口和多态;

public class test_demo {
    public static void main(String[] args) {

        Animal c1 = new Cat("加菲猫","32");
        Animal d1 = new Dog("汪汪","56");
        c1.eat();
        d1.eat();
        ((Cat)c1).catchMouse();
        ((Dog)d1).lookHome();

    }
}
