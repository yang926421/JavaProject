package 面向对象相关._01面向对象基础.手撸内部类;

public class OuterClassDemo {
    public int a = 3;
    private static  int b =4;

    public void test(){
        System.out.println();
    }

    //在类中直接定义的普通内部类
    public class InnerClassDemo{

        private int c = 5;
        public void show(){
            System.out.println("普通内部类的成员方法");
        }

    }
}
