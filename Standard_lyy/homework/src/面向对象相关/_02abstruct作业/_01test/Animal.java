package 面向对象相关._02abstruct作业._01test;

public abstract class Animal {
    private String age;
    private String color;

    public Animal(String age, String color){
        this.age = age;
        this.color =color;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
     abstract void eat();
    public void run(){
        System.out.println("动物在跑啊");
    };
    public void show(){
        System.out.println("我是父类呀");
    }
}
