package cn.gsxt.anno_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component("myAspect")
@Aspect //标注当前Aspect是一个切面类
public class MyAspect {

    //配置前置增强  代表这个包下的所有方法所有返回值类型都执行增强
    @Before("execution(* cn.gsxt.anno_aop.*.*(..))")
    public void before(){
        System.out.println("前置增强");
    }


    @After("pointcut()")
    public void after(){
        System.out.println("后置增强");
    }

    @Around("execution(* cn.gsxt.anno_aop.*.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");
    }

    //定义切点表达式
    @Pointcut("execution(* cn.gsxt.anno_aop.*.*(..))")
    public void pointcut(){}
}
