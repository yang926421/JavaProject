package 面向对象相关._03多态_包_权限修饰符.测试;

public class Student extends Person {
    public Student(String name, int age) {
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
        System.out.println("学生在学生食堂吃饭,吃什么呀");
    }
}
