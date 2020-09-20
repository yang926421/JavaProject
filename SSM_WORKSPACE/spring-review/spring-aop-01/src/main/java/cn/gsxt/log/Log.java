package cn.gsxt.log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class Log implements MethodBeforeAdvice {
    //method要执行的目标对象的方法   objects参数   o目标对象
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"方法被执行了");
    }
}
