public class test1 {
    int i = 47;

    public void call() {
        System.out.println("调用call方法");
        for (i = 0; i < 3; i++) {
            System.out.println(i + "");
            if (i == 2) {
                System.out.println("\n");
            }
        }
    }

    public static void main(String[] args) {
        test1 t1 = new test1();
        test1 t2 = new test1();
        t2.i = 60;
        System.out.println("第一个" + t1.i);
        t1.call();
//        System.out.println(i);
        System.out.println("第二个" + t2.i);
        t2.call();

    }
}
