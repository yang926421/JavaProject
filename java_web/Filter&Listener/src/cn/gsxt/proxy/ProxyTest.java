package cn.gsxt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 创建真实对象
        lenovo lenovo = new lenovo();

        //使用动态代理来增强真实lenovo
        //第一个参数  类加载器 真实对象
        // 第二个接口数组  真实对象  处理器  new InvocationHandler
        //Proxy.newProxyInstance   会返回一个代理对象
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             代理逻辑进行编写的方法,代理对象调用的所有方法都会触发该方法的执行
             参数1  代理对象proxy
             参数2  method 代理对象调用的方法都会被封装成一个对象
             参数3  代理对象调用参数时  执行时传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke方法执行了");
                //增强参数方式
                if (method.getName().equals("sale")) {
                    double money = (double) args[0];
                    money *= 0.85;
                    System.out.println("代理对象增强方法体逻辑,专车接");
                    //method是封装的方法对象  这句话的意思是使用真实对象调用该方法
//                    Object obj = method.invoke(lenovo, money);
                    //2.增强返回值类型
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("增强方法体逻辑 免费送货");
                    return obj + "鼠标垫";
                } else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        //使用代理对象,调用sale方法
        String computer = proxy_lenovo.sale(8000);

        System.out.println(computer);
    }
}
