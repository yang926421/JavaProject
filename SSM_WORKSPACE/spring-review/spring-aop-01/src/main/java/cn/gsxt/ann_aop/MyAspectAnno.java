package cn.gsxt.ann_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //标注是一个切面
public class MyAspectAnno {

    @Before("execution(* cn.gsxt.service.impl.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("注解里泡一下");
    }
}
