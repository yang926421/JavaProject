tomcat_demo1

servlet的声明周期方法

​	1.被创建 执行init,只执行一次

​	servlet什么时候被创建?

​			默认情况下,第一次被访问时,servlet被创建

​			可以配置servlet的创建时间

```
	<!--        指定servlet被创建的时机
    1.第一次被访问时创建  load-on-startup值为负数的时候 默认的是-1
    
    2.在服务器启动的时候创建,  设置为0-10正整数
    配置在servlet标签下
	-->

        <load-on-startup></load-on-startup>
    servlet的init方法,只执行一次,说明一个servlet在内存中只存在一个对象,servlet是单例的
    	多个用户同时访问可能存在线程安全问题,不能对方法加锁和同步代码块  
    		解决方案  尽量不要在service中定义成员变量 即使定义了成员变量也不要对其进行修改
```

2.提供服务

​			执行service方法,执行多次

3.被销毁

​			执行destory方法,只执行一次,服务器关闭时 servlet被销毁,只有在正常关闭才会执行



servlet3.0标准

​	支持竹节配置  可以使用web.xml也可以注解配置

​	步骤

​		1.创建javaee项目,选择servlet3.0以上的版本,可以不创建web.xml

​		2.定义一个类,实现servlet接口

​		3.复写方法

​		4.在类上使用@webServlet注解,进行配置