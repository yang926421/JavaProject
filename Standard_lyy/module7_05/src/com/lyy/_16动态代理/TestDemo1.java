package com.lyy._16动态代理;

/**
 动态代理的设计模式演示

    代理就是被代理着没有能力或者不愿意去完成某件事情 ，需要找个人替代自己去完成
 动态代理只能 为实现接口的实现类对象做代理（也可以只为接口做代理对象）
 在业务开发中经常存在很多重复的方法代码，他们前后的代码形式是一样的
 只有中间部分代码有差别！！这种时候代码冗余读很高
 有没有一种方法可以直接省略前后重复的代码就可以完成功能，这时候用动态代理。

 开发步骤
    1.必须有接口
    2.实现类要实现接口，定义自己的业务代码功能
    3.为业务功能做代理对象(动态代理 难点)


    动态代理非常的灵活，可以为任意的接口实现类对象做代理
    动态代理可以为被代理对象的所有接口的所有方法做代理
    动态代理可以在不改变方法源码的情况下，实现对方法功能的增强
    动态代理不仅简化了编程工作，而且提高了软件系统的可扩展性
        因为Java的反射机制可以生成任意类型的动态代理类
    动态代理同时也提高了开发效率
 缺点
    只能针对接口或者接口的实现类做代理对象，普通类不能做代理对象
 */
public class TestDemo1 {
    public static void main(String[] args) {
        //创建一个业务对象
        //为我们的业务对象做成一个被代理的业务对象
        UserService userService = ProxyUtil.getProxy(new UserServiceImpl());
        String rs = userService.login("admin", "123456");
        System.out.println(rs);
        userService.deleteAll();
        userService.updateAll();//走代理

    }

}
