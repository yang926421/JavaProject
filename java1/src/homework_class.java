public class homework_class {
    private int i = 1;

    public  void fun1() {
        this.i = 20;
        System.out.println("c1.i"+this.i);
    }

    public void fun2(){
        System.out.println("c2.i"+this.i);
    }
    public static void main(String[] args) {
        System.out.println("类的作业");
        homework_class c1 = new homework_class();
        homework_class c2 = new homework_class();
        c1.fun1();
        c2.fun2();

    }
}
