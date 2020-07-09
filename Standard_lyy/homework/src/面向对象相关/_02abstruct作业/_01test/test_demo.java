package 面向对象相关._02abstruct作业._01test;

public class test_demo {
    public static void main(String[] args) {
        male m1 = new male("1","红色额");
        m1.eat();
        m1.daMing();
        female m2 = new female("2", "黑色");
        m2.eat();
        Animal a3 = new male("1", "huangse");
        a3.run();
        a3.eat();
//        a3.daming();
        a3.show();//子类并没有重写  所以还是去找父类的
        
        m2.youYong();
    }

}
