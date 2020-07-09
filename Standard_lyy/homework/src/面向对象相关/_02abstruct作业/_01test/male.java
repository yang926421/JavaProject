package 面向对象相关._02abstruct作业._01test;

public class male extends Animal {
    public male(String age, String color) {
        super(age, color);
    }
    @Override
    void eat() {
        System.out.println(this.getAge()+"的公鸡呀是"+this.getColor()+"在啄米");

    }
    public void run(){
        System.out.println("男人在跑啊");
    }
    public void daMing(){
        System.out.println("公鸡会打鸣");
    }
}
