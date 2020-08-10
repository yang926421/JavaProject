# Spring

## spring快速入门

![1597041625130](assets/1597041625130.png)	1.方便解耦，简化开发

### 	spring的体系结构

![1597041919739](assets/1597041919739.png)

### Core Container核心容器

![1597042265839](assets/1597042265839.png)

使用Spring容器配置文件为了解耦

### spring程序开发的步骤

​	

```
1.导入Spring开发的基本包坐标
2.编写dao接口和实现类
3.创建Spring 核心配置XML文件
4.在Spring配置文件中配置UserDaoImpl
5.使用Spring的客户端APi获取对象
```

## spring配置文件

```
<bean id="userDao" class="cn.gsxt.dao.impl.userDaoImpl"></bean>
```

这种配置写法默认调用的是类中的无参构造函数，如果没有无参构造函数则不能创建成功

### 	基本属性   

​		id  Bean实例在容器中的唯一标识

​		class  Bean的全限名

​		scope

​			singleton 默认的，单例的

![1597045104014](assets/1597045104014.png)

​			singleton  容器中存在唯一一个对象

​			prototype  容器存在多个对象

### 对象Bean的创建时机

​	singleton  配置文件加载的时候，创建Spring容器的时候，就创建Bean对象

​	prototype 在使用容器getBean获取对象的时候才创建

![1597046147629](assets/1597046147629.png)



### Bean的生命周期

#### init-method属性    destory-method属性

```
init-method  初始化方法
destory     销毁方法

public class userDaoImpl implements userDao {
    public userDaoImpl() {
        System.out.println("userDaoImpl创建...");
    }

    public void init(){
        System.out.println("初始化方法");
    }

    public void save() {
        System.out.println("save running");
    }

    public void destory(){
        System.out.println("销毁方法");
    }
}
```



![1597046567293](assets/1597046567293.png)



### Bean实例化的三种方式

无参构造方法实例化

工厂静态方法实例化   factoryMethod = “工厂类的静态方法名” 属性  Spring解析的时候找到这个属性会解析这个工厂静态方法（下面的两种一般用于无法自己直接new对象的情况，无法通过无参构造获取）

![1597047236385](assets/1597047236385.png)

工厂实例方法

![1597047278537](assets/1597047278537.png)

### bean的依赖注入

![1597048163006](assets/1597048163006.png)

#### 依赖注入的两种方式

set 方法

```
 <bean id="userDao" class="cn.gsxt.dao.impl.userDaoImpl"></bean>
 <bean id="userService" class="cn.gsxt.service.impl.UserServiceImpl">
  	<property name="userDao" ref="userDao"></property>
 </bean>
 
 把容器内部的userDao通过UserService中的setUserDAO方法注给service,name指的是set方法的属性值，ref指要注入的对象在配置文件中的唯一标识ID
```

有参构造

```
 <bean id="userDao" class="cn.gsxt.dao.impl.userDaoImpl"></bean>
 <bean id="userService" class="cn.gsxt.service.impl.UserServiceImpl">
  	<constructor-arg name="userDao" ref="userDao"></constructor-arg>
  </bean>
  name为构造方法的参数名，ref为xml中bean的唯一标识id
```

### Bean的依赖注入的数据类型

除了对象的引用可以注入，普通数据类型，集合等都可以在容器中进行注入

普通数据类型

xml文件property标签中用value来接收值

引用数据类型

集合数据类型

### Spring的重点配置

```
<bean>标签
	id属性 在容器中Bean实例的唯一标识，不允许重复
	class属性  在容器中Bean实例的全路径名
	scope属性  Bean实例的作用范围 Singleton(默认) prototype
	<proterty>标签 属性注入 set方法的依赖注入
		name属性:属性名称  set方法后面的值的第一个字母小写
		value属性 注入的普通属性值
		ref属性 注入的对象的引用值
		<list>标签
		<map>标签
		<properties> 标签
	<constructor-arg>  有参构造方法设置依赖注入
		name属性:属性名称  set方法后面的值的第一个字母小写
		value属性 注入的普通属性值
		ref属性 注入的对象的引用值
		<list>标签
		<map>标签
		<properties> 标签
	<import>标签 导入其他spring的分配置文件
	
	
	
```

Spring相关的API

![1597052205640](assets/1597052205640.png)

![1597052342389](assets/1597052342389.png)

#### getBean方法

![1597052543371](assets/1597052543371.png)