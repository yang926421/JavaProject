package 面向对象相关._01面向对象基础._05test;

public class Teacher extends Person {
    private String xueKe;

    public String getXueKe() {
        return xueKe;
    }

    public void setXueKe(String xueKe) {
        this.xueKe = xueKe;
    }

    public Teacher() {

    }

    public Teacher(String name, int age, String xueKe) {
        super(name, age);
        this.xueKe = xueKe;
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

    public void teacher() {
        System.out.println(this.getName() + "上" + this.getXueKe());
    }
}
