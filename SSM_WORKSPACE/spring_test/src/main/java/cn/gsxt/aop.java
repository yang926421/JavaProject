//package cn.gsxt;
//
//public class aop {
//    public void run(){
//        System.out.println("在跑啊");
//    }
//}


package cn.gsxt;

import org.springframework.stereotype.Component;

@Component("aop")
public class aop {
    public void run() {
        System.out.println("在跑啊");
    }
}
