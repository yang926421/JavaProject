//package cn.gsxt;
//
//
//public class MyAspect {
//
//    public void fast(){
//        System.out.println("给你车轱辘换一下");
//    }
//}


package cn.gsxt;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect()
public class MyAspect {
    @Before("execution(* cn.gsxt.*.*(..))")
    public void fast(){
        System.out.println("给你车轱辘换一下");
    }
}
