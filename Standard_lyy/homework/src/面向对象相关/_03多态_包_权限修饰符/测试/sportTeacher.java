package 面向对象相关._03多态_包_权限修饰符.测试;

public class sportTeacher extends Teacher implements sport{
    public sportTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void playBasketBall() {
        System.out.println("我是老师呀 我也会打篮球");
    }
}
