package cn.gsxt.proxy.jdk;

import cn.gsxt.proxy.jdk.impl.targetImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        final Target target = new targetImpl();
        //增强对象
        final Advice advice = new Advice();
        Target proxy =(Target) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.before();
                method.invoke(target, args);
                advice.returning();
                return null;
            }
        });
        //调用代理对象的方法,
        proxy.save();
        InvocationHandler
                Proxy
    }
}
