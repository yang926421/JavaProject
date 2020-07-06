package com.lyy._16动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    /**
     做一个被代理的业务对象返回
     */
    public static <T> T getProxy(Object obj){
        /**
         * 参数一  类加载器，负责加载到时候做好的业务代理对象！
         * 参数二  被代理业务对象的全部实现的接口，以便有代理对象可以知道要为哪些方法做代理
         * 参数三  代理真正的执行方法  也就是代理处理的逻辑
         *

         */
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
                        //PROXY  业务代理对象本身  用不到
                        // method  代表当前正在被代理执行的方法
                        //parms 代表的时是执行方法的参数，数组的形式
                        long startTime = System.currentTimeMillis();
                        //真正触发真实的方法执行
                        Object rs = method.invoke(obj, params);
                        long endTime =  System.currentTimeMillis();
                        System.out.println(method.getName()+"方法耗时"+(endTime-startTime)/1000+"s");
                        return rs;//返回方法执行的结果
                    }
                });
    }
}
