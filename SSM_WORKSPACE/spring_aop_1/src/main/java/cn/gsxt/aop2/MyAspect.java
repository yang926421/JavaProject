package cn.gsxt.aop2;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){
        System.out.println("前置增强");
    }

    public void after(){
        System.out.println("后置增强");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");
    }
}
