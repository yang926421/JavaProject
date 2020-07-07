package 面向对象相关._01面向对象基础._04test;

public class PhoneTest {
    public static void main(String[] args) {
        HWPhone h1 = new HWPhone("p30", 3999.0, "黄色");
        HWPhone.brand = "啥也不是";


        h1.call();
        System.out.println(HWPhone.brand + h1.getColor() + h1.getPrice() + h1.getType());
    }
}
