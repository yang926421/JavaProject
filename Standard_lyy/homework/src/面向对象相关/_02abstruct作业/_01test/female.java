package 面向对象相关._02abstruct作业._01test;

public class female extends Animal{
    public female(String age, String color) {
        super(age, color);
    }

    @Override
    void eat() {
        System.out.println("鸭子呀"+this.getAge()+this.getColor()+"在吃饭");
    }

    public void youYong(){
        System.out.println(this.getAge()+this.getColor()+"鸭子呀"+"在游泳");
    }
}
