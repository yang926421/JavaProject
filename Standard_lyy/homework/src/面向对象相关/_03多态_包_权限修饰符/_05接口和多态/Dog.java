package 面向对象相关._03多态_包_权限修饰符._05接口和多态;

public class Dog extends Animal {
    public Dog(String name, String weight) {
        super(name, weight);
    }

    @Override
    public void eat() {
        System.out.println("这是狗的dog方法,狗在吃呀");
    }

    public void lookHome(){
        System.out.println("狗在看家门呀");
    }
}
