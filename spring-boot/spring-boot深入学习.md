# spring-boot深入学习

业务

service: userService  分布式情况下  业务放分开发那么这个服务就要独立放 提供接口

![1598491092184](assets/1598491092184.png)

![1598492736154](assets/1598492736154.png)

微服务的文章(汉译)

https://www.cnblogs.com/liuning8023/p/4493156.html

## 静态文件的导入

1.springboot中可以以下方式处理静态资源

​	webjars   localhost:8080/webjars/

​	resources下配置的这三个目录  pulic static resources下  存放的资源可以直接ip:port/资源名称   访问

```
webjars(一个)
以maven坐标的方式导入静态文件

```

![image-20200828230527315](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200828230527315.png)

同名文件resources优先级大于static大于public

resources>static(默认)>public

一般在public下放一些公共的资源,比如都会访问的js,static下放一些静态资源,比如说图片,resources下放一些上传的文件

## template下的所有页面,只能通过controller来跳转,需要模板引擎thymeleaf的支持

resources>static(默认)>public   下的index.html

![image-20200829170759653](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829170759653.png)

一般都放在template下   只能通过controller访问到这个文件夹

springboot2.0版本设置网址图标

![image-20200829204143725](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829204143725.png)

index文件

```
<!DOCTYPE html>
<html  lang="en" xmlns:th="http://www.thymeleaf.org" >
<head>
    <title>主页</title>
    <link rel="icon" href="favicon.ico" >
    <!-- <link rel="icon" th:href="@{favicon.ico}" >  <!-- thymeleaf方式-->
</head>
<body>
<h2>This is a homepage!!</h2>
</body>
</html>

```

![image-20200829204246377](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829204246377.png)

# thymeleaf模板引擎

![image-20200829204453147](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829204453147.png)

![image-20200829205739545](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829205739545.png)

## 结论

​	只要需要使用thymeleaf,只需要导入对应的依赖即可,我们将html页面放在我们的template下即可

## 使用thymeleaf

1.导入命名空间

2.在html页面取值

​	$取变量

所有的html元素都可以被thymeleaf替换接管   th:元素名

```
<div th:text="${message}"></div> 
java类中
model.addAttribute("message","hello,lyy");
return "test";
```



### thymeleaf基础语法

![image-20200829212931961](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829212931961.png)

### test和untest(将含有html标签的内容转义)

```
 model.addAttribute("message","<h1>hello,springBoot<h1>");
 return "test";

<div th:text="${message}"></div>
<div th:utext="${message}"></div>
```

![image-20200829213348644](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829213348644.png)



### 遍历的两种方式

```
 model.addAttribute("users", Arrays.asList("lyy","hht"));
 return "test";
<h3 th:each="user:${users}" th:text="${user}"></h3>
<h3 th:each="user:${users}">[[${user}]]</h3>
```

![image-20200829214527498](spring-boot%E6%B7%B1%E5%85%A5%E5%AD%A6%E4%B9%A0.assets/image-20200829214527498.png)

国际化

i18n

*i18n*（其来源是英文单词 internationalization的首末字符i和n，18为中间的字符数）是“国际化”的简称。

k8s

*k8s*全称kubernetes,这个名字大家应该都不陌生,*k8s*是为容器服务而生的一个可移植容器的编排管理工具,越来越多的公司正在拥抱*k8s*,并且当前*k8s*已经主导了云业务流程

