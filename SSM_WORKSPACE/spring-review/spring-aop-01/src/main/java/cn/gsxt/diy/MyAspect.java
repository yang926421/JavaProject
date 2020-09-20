package cn.gsxt.diy;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MyAspect {
    @Before("execution(* cn.gsxt.anno_aop.*.*(..))")
    public void before() {
        System.out.println("前置增强");
    }
}
