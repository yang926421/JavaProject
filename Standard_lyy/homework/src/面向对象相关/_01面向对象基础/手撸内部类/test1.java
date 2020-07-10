package 面向对象相关._01面向对象基础.手撸内部类;

public class test1 {
    public static void main(String[] args) {
        OuterClassDemo o1 = new OuterClassDemo();
        OuterClassDemo.InnerClassDemo i1= o1.new InnerClassDemo();
        System.out.println(o1.a);
    }
}
