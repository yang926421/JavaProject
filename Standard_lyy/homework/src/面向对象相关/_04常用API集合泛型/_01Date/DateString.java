package 面向对象相关._04常用API集合泛型._01Date;

public class DateString {
    public static void main(String[] args) {
        // a) 使用System的currentTimeMillis()方法获取当前操作系统的毫秒值,作用程序执行的开始时间,使用start变量接收
        long start = System.currentTimeMillis();
        // b)需要测试执行性能的代码
//        testString(); //消耗时间: 29295毫秒
        test();
        // c)使用System的currentTimeMillis()方法获取当前操作系统的毫秒值,作用程序执行的结束时间,使用end变量接收
        long end = System.currentTimeMillis();
        // d)计算代码执行花费的时间 end - start,输出代码执行消耗的时间
        System.out.println("所花费的时间为:" + (end - start));
    }

    public static void test() {
//        创建一个StringBuilder对象  sb  初始化内容为hello
        StringBuilder sb = new StringBuilder("HELLO");
        for (int i = 0; i < 100000; i++) {
            sb.append("world");
        }
        // 循环结束后转为字符串
        String newStr = sb.toString();
        System.out.println(newStr);
    }
}
/**
 *
 */
