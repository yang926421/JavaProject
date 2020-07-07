package 面向对象相关._01面向对象基础._05test;

public class Student extends Person{
    private String score;
    public Student() {
        super();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Student(String name, int age, String score) {
        super(name, age);
        this.score = score;
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
    public void test_own(){
        System.out.println(this.getName() + "考试呀");
    }
}
