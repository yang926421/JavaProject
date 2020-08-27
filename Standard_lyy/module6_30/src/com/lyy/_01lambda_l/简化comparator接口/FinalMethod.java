package com.lyy._01lambda_l.简化comparator接口;


import java.lang.reflect.Method;

class Parents {
    private final void doit() {
        System.out.println("父类的doit");
    }

    final void doit2() {
        System.out.println("父类的doit2");
    }

    public void doit3() {
        System.out.println("父类的doit3");
    }
}

class Sub extends Parents {
    public final void doit() {
        System.out.println("子类的doit");
    }

    //    final void doit2(){
//        System.out.println("子类的doit2");
//    }
    public void doit3() {
        System.out.println("子类的doit3");
    }
}


public class FinalMethod {
    public static void main(String[] args) {
//        Sub s = new Sub();
//        s.doit();
//        s.doit3();
//        Parents p = s;
        Parents p = new Sub();
        p.doit2();
        p.doit3();
    }
}
