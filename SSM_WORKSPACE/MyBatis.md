

# MyBatis

## 1、简介

### 1.1 什么是Mybatis

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020062316463790.png)

- **MyBatis 是一款优秀的持久层框架;**
- 它支持自定义 SQL、存储过程以及高级映射。
- MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。
- MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

### 1.2 持久化

数据持久化

- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
- 内存：**断电即失**
- 数据库（Jdbc）,io文件持久化。

**为什么要持久化？**

- 有一些对象，不能让他丢掉
- 内存太贵

### 1.3 持久层

Dao层、Service层、Controller层

- 完成持久化工作的代码块

- 层界限十分明显

  maven仓库获得mybatis

  ```xml
  <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.2</version>
  </dependency>
  ```

  

### 1.4 为什么需要MyBatis

- 帮助程序员将数据存入到数据库中
- 方便
- 传统的JDBC代码太复杂了，简化，框架，自动化
- 不用MyBatis也可以，技术没有高低之分
- 优点：
  - 简单易学
  - 灵活
  - sql和代码的分离，提高了可维护性。
  - 提供映射标签，支持对象与数据库的orm字段关系映射
  - 提供对象关系映射标签，支持对象关系组建维护
  - 提供xml标签，支持编写动态sql

## 2、第一个Mybatis程序

思路：搭建环境 --> 导入MyBatis --> 编写代码 --> 测试

### 2.1 搭建环境

新建项目

1. 创建一个普通的maven项目

2. 删除src目录 （就可以把此工程当做父工程了，然后创建子工程）

3. 导入maven依赖

   ```xml
   <!--导入依赖-->
   <dependencies>
       <!--mysqlq驱动-->
       <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>8.0.12</version>
       </dependency>
       <!--mybatis-->
       <dependency>
           <groupId>org.mybatis</groupId>
           <artifactId>mybatis</artifactId>
           <version>3.5.4</version>
       </dependency>
       <!--junit-->
       <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
           <version>4.12</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```

4. 创建一个Module

### 2.2 创建一个模块

- 编写mybatis的核心配置文件

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
  <configuration>
      <!--    引入properties文件-->
      <properties resource="jdbc.properties"></properties>
      <environments default="development">
          <environment id="development">
              <transactionManager type="JDBC"></transactionManager>
              <dataSource type="POOLED">
                  <property name="driver" value="${jdbc.driver}"/>
                  <property name="url" value="${jdbc.url}"/>
                  <property name="username" value="${jdbc.username}"/>
                  <property name="password" value="${jdbc.password}"/>
              </dataSource>
          </environment>
      </environments>
      <!-- 每一个mapper。xml文件都需要在mybatis的核心配置文件配置    -->
      <mappers>
          <mapper resource="mapper/UserMapper.xml"></mapper>
      </mappers>
  </configuration>
  ```

- 编写mybatis工具类

  ```java
  package cn.gsxt.utils;
  
  import org.apache.ibatis.io.Resources;
  import org.apache.ibatis.session.SqlSession;
  import org.apache.ibatis.session.SqlSessionFactory;
  import org.apache.ibatis.session.SqlSessionFactoryBuilder;
  
  import java.io.IOException;
  import java.io.InputStream;
  
  //sqlSessionFactory  --->  sqlSession
  public class MybatisUtils {
  
      private static SqlSessionFactory sqlSessionFactory;
  
      static{
          try {
              String resource = "mybatis-config.xml";
              InputStream resourceAsStream = Resources.getResourceAsStream(resource);
              //获取sqlSessionFactory创造器
              sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  
      //通过sqlSession来执行sql
  
      public static SqlSession getSqlSession(){
           SqlSession sqlSession = sqlSessionFactory.openSession(true);
           return sqlSession;
      }
  
      //关闭sqlsession
  
  
  }
  
  ```

### 2.3 编写代码

- 实体类

- Dao接口

  ```java
  public interface UserDao {
      public List<User> getUserList();
  }
  ```

- 接口实现类 （由原来的UserDaoImpl转变为一个Mapper配置文件）

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
  <mapper namespace="cn.gsxt.mapper.UserMapper">
      <select id="getUserList" resultType="cn.gsxt.module.User">
          select * from user;
      </select>
  </mapper>
  
  ```

- 测试

  **MapperRegistry是什么?**

  核心配置文件中注册mappers

  - junit测试

    ```java
        @Test
        public void test(){
    
            //1.获取SqlSession对象
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            //2.执行SQL
            // 方式一：getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
    
            //关闭sqlSession
            sqlSession.close();
        }
    ```

**可能会遇到的问题：**

1. 配置文件没有注册
2. 绑定接口错误
3. 方法名不对
4. 返回类型不对
5. Maven导出资源问题

## 3、CURD

### 1. namespace

namespace中的包名要和Dao/Mapper接口的包名一致

### 2. select

选择，查询语句；

- id：就是对应的namespace中的方法名；

- resultType : Sql语句执行的返回值；

- parameterType : 参数类型；

  1. 编写接口

     ```java
     package cn.gsxt.mapper;
     
     import cn.gsxt.module.User;
     
     import java.util.List;
     
     public interface UserMapper {
         public List<User> getUserList();
     
         // 增加用户
         public void insertUser(User user);
     }
     
     ```

  2. 编写对应的mapper中的sql语句

     ```xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     
     <mapper namespace="cn.gsxt.mapper.UserMapper">
         <select id="getUserList" resultType="cn.gsxt.module.User">
             select * from user;
         </select>
     
         <!--插入增加用户 -->
         <insert id="insertUser" parameterType="cn.gsxt.module.User">
             insert into user (`id`, `name`, `pwd`) values (#{id}, #{name}, #{pwd})
         </insert>
     </mapper>
     
     ```

  3. 测试

     ```java
     @Test
     public void test2() {
         SqlSession sqlSession = MybatisUtils.getSqlSession();
         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
         User user  = new User(3,"黑子","666");
         mapper.addUser(user);
         //增删改一定要提交事务
         sqlSession.commit();
     
         //关闭sqlSession
         sqlSession.close();
     }
     ```

     **注意：增删改查一定要提交事务：*(可以默认提交事务  获取session的时候**sqlSessionFactory.openSession(true)**)**_

     ```java
     sqlSession.commit();
     ```

### 3. Insert

### 4. update

### 5. Delete

### 6. 万能Map

假设，我们的实体类，或者数据库中的表，字段或者参数过多，我们应该考虑使用Map!

1. UserMapper接口

```java
//用万能Map插入用户
public void addUser2(Map<String,Object> map);
```

1. UserMapper.xml

```xml
<!--对象中的属性可以直接取出来 传递map的key-->
<insert id="addUser2" parameterType="map">
    insert into user (id,name,password) values (#{userid},#{username},#{userpassword})
</insert>
```

1. 测试

```java
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",4);
        map.put("username","王虎");
        map.put("userpassword",789);
        mapper.addUser2(map);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
```

> Map传递参数，直接在sql中取出key即可！ 【parameter=“map”】
>
> 对象传递参数，直接在sql中取出对象的属性即可！ 【parameter=“Object”】
>
> 只有一个基本类型参数的情况下，可以直接在sql中取到
>
> 多个参数用Map , **或者注解！**

### 7. 模糊查询

模糊查询这么写？

1. Java代码执行的时候，传递通配符% %

   ```java
   List<User> userList = mapper.getUserLike("%李%");
   ```

2. 在sql拼接中使用通配符

   ```xml
   select * from user where name like "%"#{value}"%"
   ```

## 4、配置解析

### 1. 核心配置文件

- mybatis-config.xml

- Mybatis的配置文件包含了会深深影响MyBatis行为的设置和属性信息。

  ```xml
  configuration（配置）
      properties（属性）
      settings（设置）
      typeAliases（类型别名）
      typeHandlers（类型处理器）
      objectFactory（对象工厂）
      plugins（插件）
      environments（环境配置）
      	environment（环境变量）
      		transactionManager（事务管理器）
      		dataSource（数据源）
      databaseIdProvider（数据库厂商标识）
      mappers（映射器）
  ```

### 2. 环境配置 environments

MyBatis 可以配置成适应多种环境

**不过要记住：尽管可以配置多个环境，但每个 SqlSessionFactory 实例只能选择一种环境**

学会使用配置多套运行环境！

MyBatis默认的事务管理器就是JDBC ，连接池：POOLED

### 3. 属性 properties

我们可以通过properties属性来实现引用配置文件

这些属性可以在外部进行配置，并可以进行动态替换。你既可以在典型的 Java 属性文件中配置这些属性，也可以在 properties 元素的子元素中设置。【db.poperties】

1. 编写一个配置文件

   jdbc.properties

   ```properties
   jdbc.driver=com.mysql.jdbc.Driver
   jdbc.url=jdbc:mysql://localhost:3306/ssmtest
   #jdbc.url=jdbc:mysql://localhost:3306/ssmtest?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8
   jdbc.username=root
   jdbc.password=123
   ```

2. 在核心配置文件中引入

   ```xml
   <!--引用外部配置文件-->
   <properties resource="jdbc.properties">
        <property name="driver" value="${jdbc.driver}"/>
                   <property name="url" value="${jdbc.url}"/>
                   <property name="username" value="${jdbc.username}"/>
                   <property name="password" value="${jdbc.password}"/>
              
   </properties>
   ```

   - 可以直接引入外部文件
   - 可以在其中增加一些属性配置
   - 如果两个文件有同一个字段，xml文件中的先使用,随后被覆盖.外部配置文件的

### 4. 类型别名 typeAliases

- 类型别名可为 Java 类型设置一个缩写名字。 它仅用于 XML 配置.

- 意在降低冗余的全限定类名书写。

  ```xml
  <!--可以给实体类起别名-->
   <typeAliases>
  <typeAlias type="cn.gsxt.module.User" alias="user"/>
  </typeAliases>
  ```

  也可以指定一个包，每一个在包 `domain.blog` 中的 Java Bean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。 比如 `domain.blog.Author` 的别名为 `author`,；若有注解，则别名为其注解值。见下面的例子：

  ```xml
  <typeAliases>
      <package name="cn.gsxt.module"/>
  </typeAliases>
  ```

  > 在实体类比较少的时候，使用第一种方式。
  >
  > 如果实体类十分多，建议用第二种扫描包的方式。
  >
  > 第一种可以DIY别名，第二种不行，如果非要改，需要在实体上增加注解。

  ```java
  @Alias("author")
  public class Author {
      ...
  }
  ```

### 5. 设置 Settings

这是 MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为。

开启缓存和懒加载以及日志设置

![1600147304360](assets/1600147304360.png)

![1600147335260](assets/1600147335260.png)

### 6. 其他配置

- [typeHandlers（类型处理器）](https://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers)
- [objectFactory（对象工厂）](https://mybatis.org/mybatis-3/zh/configuration.html#objectFactory)
- plugins 插件
  - mybatis-generator-core
  - mybatis-plus
  - 通用mapper

### 7. 映射器 mappers

MapperRegistry：注册绑定我们的Mapper文件；

方式一：【推荐使用】

```xml
<!--每一个Mapper.xml都需要在MyBatis核心配置文件中注册-->
<mappers>
    <mapper resource="com/kuang/dao/UserMapper.xml"/>
</mappers>
```

方式二：使用class文件绑定注册

```xml
<!--每一个Mapper.xml都需要在MyBatis核心配置文件中注册-->
<mappers>
    <mapper class="com.kuang.dao.UserMapper"/>
</mappers>
```

**注意点：**

- 接口和他的Mapper配置文件必须同名
- 接口和他的Mapper配置文件必须在同一个包下

方式三：使用包扫描进行注入

![1600152965294](assets/1600152965294.png)

```xml
<mappers>
    <package name="com.kuang.dao"/>
</mappers>
```

### 8. 作用域和生命周期

![1600153809377](assets/1600153809377.png)

声明周期和作用域是至关重要的，因为错误的使用会导致非常严重的**并发问题**。

**SqlSessionFactoryBuilder:**

- 一旦创建了SqlSessionFactory，就不再需要它了
- 局部变量

**SqlSessionFactory:**

- 说白了就可以想象为：数据库连接池
- SqlSessionFactory一旦被创建就应该在应用的运行期间一直存在，**没有任何理由丢弃它或重新创建一个实例。**
- 因此SqlSessionFactory的最佳作用域是应用作用域（ApplicationContext）。
- 最简单的就是使用**单例模式**或静态单例模式。

**SqlSession：**

- 连接到连接池的一个请求
- SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。
- 用完之后需要赶紧关闭，否则资源被占用！

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164833872.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

## 5、(ResultMap)解决属性名和字段名不一致的问题

### 1. 问题

数据库中的字段

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164845962.png)

新建一个项目，拷贝之前的，测试实体类字段不一致的情况

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164853569.png)

测试出现问题
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164901861.png)

```xml
// select * from user where id = #{id}
// 类型处理器
// select id,name,pwd from user where id = #{id}
```

解决方法：

- 起别名

```xml
<select id="getUserById" resultType="com.kuang.pojo.User">
    select id,name,pwd as password from USER where id = #{id}
</select>
```

### 2. resultMap

结果集映射

> 数据库字段    id name pwd
>
> 实体类字段                 id username password

```xml
 <!--  结果集映射  -->
    <resultMap id="UserMap" type="user">
        <result column="id" property="id"/>
        <result column="name" property="username"/>
        <result column="pwd" property="password"/>
    </resultMap>
    <select id="findUserById" parameterType="int" resultMap="UserMap">
        select * from user where id=#{id}
    </select>
```

- `resultMap` 元素是 MyBatis 中最重要最强大的元素。
- ResultMap 的设计思想是，对简单的语句做到零配置，对于复杂一点的语句，只需要描述语句之间的关系就行了。
- `ResultMap` 的优秀之处——你完全可以不用显式地配置它们。
- 如果这个世界总是这么简单就好了。

## 6、日志

### 6.1 日志工厂

如果一个数据库操作，出现了异常，我们需要排错，日志就是最好的助手！

曾经：sout、debug

现在：日志工厂

![img](https://img-blog.csdnimg.cn/20200623164920502.png)

- SLF4J
- LOG4J 【掌握】
- LOG4J2
- JDK_LOGGING
- COMMONS_LOGGING
- STDOUT_LOGGING 【掌握】
- NO_LOGGING

在MyBatis中具体使用哪一个日志实现，在设置中设定

**STDOUT_LOGGING**

```xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020062316493391.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

### 6.2 Log4j(可以结合自己博客园的文章)

什么是Log4j？

- Log4j是[Apache](https://baike.baidu.com/item/Apache/8512995)的一个开源项目，通过使用Log4j，我们可以控制日志信息输送的目的地是[控制台](https://baike.baidu.com/item/控制台/2438626)、文件、[GUI](https://baike.baidu.com/item/GUI)组件；
- 我们也可以控制每一条日志的输出格式；
- 通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程；
- 最令人感兴趣的就是，这些可以通过一个[配置文件](https://baike.baidu.com/item/配置文件/286550)来灵活地进行配置，而不需要修改应用的代码。

1. 先导入log4j的包

   ```xml
   <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>1.2.17</version>
   </dependency>
   ```

2. log4j.properties

   ```xml
   #将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
   log4j.rootLogger=DEBUG,console,file
   
   #控制台输出的相关设置
   log4j.appender.console = org.apache.log4j.ConsoleAppender
   log4j.appender.console.Target = System.out
   log4j.appender.console.Threshold=DEBUG
   log4j.appender.console.layout = org.apache.log4j.PatternLayout
   log4j.appender.console.layout.ConversionPattern=[%c]-%m%n
   #文件输出的相关设置
   log4j.appender.file = org.apache.log4j.RollingFileAppender
   log4j.appender.file.File=./log/rzp.log
   log4j.appender.file.MaxFileSize=10mb
   log4j.appender.file.Threshold=DEBUG
   log4j.appender.file.layout=org.apache.log4j.PatternLayout
   log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n
   #日志输出级别
   log4j.logger.org.mybatis=DEBUG
   log4j.logger.java.sql=DEBUG
   log4j.logger.java.sql.Statement=DEBUG
   log4j.logger.java.sql.ResultSet=DEBUG
   log4j.logger.java.sq1.PreparedStatement=DEBUG
   ```

3. 配置settings为log4j实现

4. 测试运行

**Log4j简单使用**

```
//在日志中进行自定义 加输出语句
```

1. 在要使用Log4j的类中，导入包 import org.apache.log4j.Logger;

2. 获取日志对象，参数为当前类的class对象

   ```java
   Logger logger = Logger.getLogger(UserDaoTest.class);
   ```

3. 日志级别

   ```java
   logger.info("info: 测试log4j");
   logger.debug("debug: 测试log4j");
   logger.error("error:测试log4j");
   ```

   1. info
   2. debug
   3. error

## 7、分页

**思考：为什么分页？**

- 减少数据的处理量

### 7.1 **使用Limit分页**

```sql
SELECT * from user limit startIndex,pageSize 
select * from user limit 3;//第一个参数不写 默认从0开始 [0-n-1]
```

**使用MyBatis实现分页，核心SQL**

1. 接口

   ```java
   //分页
   List<User> getUserByLimit(Map<String,Integer> map);
   ```

2. Mapper.xml

   ```xml
   <!--分页查询-->
   <select id="getUserByLimit" parameterType="map" resultMap="UserMap">
       select * from user limit #{startIndex},#{pageSize}
   </select>
   ```

3. 测试

   ```java
       @Test
       public void getUserByLimit(){
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           HashMap<String, Integer> map = new HashMap<String, Integer>();
           map.put("startIndex",1);
           map.put("pageSize",2);
           List<User> list = mapper.getUserByLimit(map);
           for (User user : list) {
               System.out.println(user);
           }
       }
   ```

### 7.2 RowBounds分页

不再使用SQL实现分页

1. 接口

   ```xml
   //分页2
   List<User> getUserByRowBounds();
   ```

2. mapper.xml

   ```xml
   <!--分页查询2-->
   <select id="getUserByRowBounds">
       select * from user limit #{startIndex},#{pageSize}
   </select>
   ```

3. 测试

   ```java
       public void getUserByRowBounds(){
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           //RowBounds实现
           RowBounds rowBounds = new RowBounds(1, 2);
           //通过Java代码层面实现分页
           List<User> userList = sqlSession.selectList("com.kaung.dao.UserMapper.getUserByRowBounds", null, rowBounds);
           for (User user : userList) {
               System.out.println(user);
           }
           sqlSession.close();
       }
   ```

### 7.3 分页插件

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164958936.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)



MyBatis可以使用第三方的插件来对功能进行扩展，分页助手PageHelper是将分页的复杂操作进行封装，使用简单的方式即可获得分页的相关数据

开发步骤：

①导入通用PageHelper的坐标

②在mybatis核心配置文件中配置PageHelper插件

③测试分页数据获取



##### ①导入通用PageHelper坐标

```xml
<!-- 分页助手 -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>3.7.5</version>
</dependency>
<dependency>
    <groupId>com.github.jsqlparser</groupId>
    <artifactId>jsqlparser</artifactId>
    <version>0.9.1</version>
</dependency>

```

##### ②在mybatis核心配置文件中配置PageHelper插件

```xml
<!-- 注意：分页助手的插件  配置在通用馆mapper之前 -->
  <!--    配置分页助手插件-->
    <plugins>
        <plugin interceptor="com.github.pagehelper.PageHelper">
            <!--            不同的数据库使用的分页都不一样-->
            <property name="dialect" value="mysql"/>
        </plugin>
    </plugins>
```

##### ③测试分页代码实现

```java
  // 在分页组件的加持下
    @Test
    public void test2(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper映射文件 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1, 2);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();

    }
```

**获得分页相关的其他参数**

```java
//其他分页的数据
PageInfo<User> pageInfo = new PageInfo<User>(select);
System.out.println("总条数："+pageInfo.getTotal());
System.out.println("总页数："+pageInfo.getPages());
System.out.println("当前页："+pageInfo.getPageNum());
System.out.println("每页显示长度："+pageInfo.getPageSize());
System.out.println("是否第一页："+pageInfo.isIsFirstPage());
System.out.println("是否最后一页："+pageInfo.isIsLastPage());

```

#### 

## 8、使用注解开发

![image-20200915215011473](MyBatis.assets/image-20200915215011473.png)

### 8.1 面向接口开发

**三个面向区别**

- 面向对象是指，我们考虑问题时，以对象为单位，考虑它的属性和方法；
- 面向过程是指，我们考虑问题时，以一个具体的流程（事务过程）为单位，考虑它的实现；
- 接口设计与非接口设计是针对复用技术而言的，与面向对象（过程）不是一个问题，更多的体现就是对系统整体的架构；

### 8.2 使用注解开发

1. 注解在接口上实现

   ```java
   @Select("select * from user")
   List<User> getUsers();
   ```

2. 需要在核心配置文件中绑定接口

   ```xml
   <mappers>
           <package name="cn.gsxt.mapper"/>
   </mappers>
   ```

3. 测试

本质：反射机制实现

底层：动态代理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165014965.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

**MyBatis详细执行流程**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165030775.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70#pic_center)

### 8.3 注解CURD

```java
//方法存在多个参数，所有的参数前面必须加上@Param("id")注解
@Delete("delete from user where id = ${uid}")
int deleteUser(@Param("uid") int id);
```

**关于@Param( )注解**

- 基本类型的参数或者String类型，需要加上
- 引用类型不需要加
- 如果只有一个基本类型的话，可以忽略，但是建议大家都加上
- 我们在SQL中引用的就是我们这里的@Param()中设定的属性名
- ![image-20200915225059093](MyBatis.assets/image-20200915225059093.png)

## **#{} 和 ${}的区别**

#{}预编译 防止sql注入

## 9、Lombok

Lombok项目是一个Java库，它会自动插入编辑器和构建工具中，Lombok提供了一组有用的注释，用来消除Java类中的大量样板代码。仅五个字符(@Data)就可以替换数百行代码从而产生干净，简洁且易于维护的Java类。

使用步骤：

1. 在IDEA中安装Lombok插件

2. 在项目中导入lombok的jar包

   ```xml
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.10</version>
       <scope>provided</scope>
   </dependency>
   ```

3. 在程序上加注解

```java
@Getter and @Setter
@FieldNameConstants
@ToString
@EqualsAndHashCode
@AllArgsConstructor, @RequiredArgsConstructor and @NoArgsConstructor
@Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
@Data
@Builder
@SuperBuilder
@Singular
@Delegate
@Value
@Accessors
@Wither
@With
@SneakyThrows
@val
```

说明：

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165052167.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

## 10、多对一处理

> 多个学生一个老师；

​```sql
alter table student ADD CONSTRAINT fk_tid foreign key (tid) references teacher(id
```

### **1. 测试环境搭建**

1. 导入lombok
2. 新建实体类Teacher,Student
3. 建立Mapper接口
4. 建立Mapper.xml文件
5. 在核心配置文件中绑定注册我们的Mapper接口或者文件 【方式很多，随心选】
6. 测试查询是否能够成功

### 2. 按照查询嵌套处理

```xml
<!--
     思路：
        1. 查询所有的学生信息
        2. 根据查询出来的学生的tid寻找特定的老师 (子查询)
    -->
 <resultMap id="studentTea" type="student">
        <result property="id" column="id"/>
        <result property="name" column="name"/>
     
     <!--  teacher复杂的属性  -->这块儿的select是调用select  可以调用其他接口中的方法, 比如可以调用
     TeacherMapper的getTeacher方法  Teachermapper.xml中具体实现
        <association property="teacher" column="tid" javaType="Teacher" select="getTeacher"/>
    </resultMap>
    <select id="findAllStudent" resultMap="studentTea">
        select * from student
    </select>

    <select id="getTeacher" resultType="teacher">
        select * from teacher where id=#{id}
    </select>
```

### 3.按照结果嵌套处理

```xml
<!--结果封装，将查询出来的列封装到对象属性中-->   
<resultMap id="studentTea2" type="student">
        <id column="sid" property="id"/>
        <result column="sname" property="name"/>
        <association property="teacher" javaType="teacher">
            <result property="name" column="tname"/>
        </association>
    </resultMap>
    <select id="findAllStudent2" resultMap="studentTea2">
        select s.id sid, s.name sname , t.name tname from student s, teacher t where s.tid = t.id
    </select>
   
```

回顾Mysql多对一查询方式:

- 子查询 （按照查询嵌套）
- 联表查询 （按照结果嵌套）

## 11、一对多处理

> 一个老师多个学生；
>
> 对于老师而言，就是一对多的关系；

### 1. 环境搭建

**实体类**

```java
@Data
public class Student {
    private int id;
    private String name;
    private int tid;
}
123456
@Data
public class Teacher {
    private int id;
    private String name;

    //一个老师拥有多个学生
    private List<Student> students;
}
```

### 2. **按照结果嵌套嵌套处理**

```xml
<!--按结果嵌套查询-->
 <resultMap id="TeacherAndStudent" type="Teacher">
        <result column="tid" property="id"/>
        <result column="tname" property="name"/>
        <!--复杂的属性，我们需要单独处理 对象：association 集合：collection
   javaType=""指定属性的类型！
   因为我们使用的是List<Student>集合中的泛型信息，我们使用ofType获取
   -->
        <collection property="students" ofType="Student">
            <result column="sid" property="id"/>
            <result column="sname" property="name"/>
            <result column="tid" property="tid"/>
        </collection>
    </resultMap>
    <select id="findAllTeacherAndStudent" resultMap="TeacherAndStudent">
        select t.id tid, t.name tname, s.name sname, s.id sid from teacher t , student s where t.id = s.tid and t.id=#{tid}
    </select>
```

**按照子查询处理**

![1600244257065](assets/1600244257065.png)

### 小结

1. 关联 - association 【多对一】
2. 集合 - collection 【一对多】
3. javaType & ofType
   1. JavaType用来指定实体类中的类型
   2. ofType用来指定映射到List或者集合中的pojo类型，泛型中的约束类型

 **注意点：**

- 保证SQL的可读性，尽量保证通俗易懂
- 注意一对多和多对一，属性名和字段的问题
- 如果问题不好排查错误，可以使用日志，建议使用Log4j

面试高频

- Mysql引擎
- InnoDB底层原理
- 索引
- 索引优化

## 12、动态SQL

**什么是动态SQL：动态SQL就是根据不同的条件生成不同的SQL语句**

**所谓的动态SQL，本质上还是SQL语句，只是我们可以在SQL层面，去执行一个逻辑代码**

------

> 动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC 或其它类似的框架，你应该能理解根据不同条件拼接 SQL 语句有多痛苦，例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL，可以彻底摆脱这种痛苦。

### 搭建环境

```sql
CREATE TABLE `mybatis`.`blog`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `title` varchar(30) NOT NULL COMMENT '博客标题',
  `author` varchar(30) NOT NULL COMMENT '博客作者',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `views` int(30) NOT NULL COMMENT '浏览量',
  PRIMARY KEY (`id`)
)
```

创建一个基础工程

1. 导包

2. 编写配置文件

3. 编写实体类

   ```java
   @Data
   public class Blog {
       private int id;
       private String title;
       private String author;
   
       private Date createTime;// 属性名和字段名不一致
       private int views;
   }
   ```

4. 编写实体类对应Mapper接口和Mapper.xml文件

### IF

```xml
<select id="queryBlogIF" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <if test="title!=null">
            and title = #{title}
        </if>
        <if test="author!=null">
            and author = #{author}
        </if>
    </where>
</select>
```

### choose (when, otherwise)

choose可以选择所有when中的满足的条件 只要满足第一个 就不会再拼接,

如果choose都不满足 则会执行 otherwise

![1600251466608](assets/1600251466608.png)





### trim、where、set(trim 我们一般where 和set就够用了)

sql拼接的时候where会自动监测第一个拼接的子语句是否是第一个  如果是第一个且含有or and 之类的 会自动将and  or去除  

![1600250697999](assets/1600250697999.png)

![1600250863891](assets/1600250863891.png)

#### set的作用

![1600252115050](assets/1600252115050.png)

所谓的动态sql,本质上还是sql语句,只是我们可以在sql层面,去执行一个逻辑代码

### SQL片段

有的时候，我们可能会将一些功能的部分抽取出来，方便服用！

1. 使用SQL标签抽取公共部分可

   ```xml
   <sql id="if-title-author">
       <if test="title!=null">
           title = #{title}
       </if>
       <if test="author!=null">
           and author = #{author}
       </if>
   </sql>
   ```

2. 在需要使用的地方使用Include标签引用即可

   ```xml
   <select id="queryBlogIF" parameterType="map" resultType="blog">
       select * from blog
       <where>
           <include refid="if-title-author"></include>
       </where>
   </select>
   ```

注意事项：

- 最好基于单标来定义SQL片段
- 不要存在where标签

# 什么是动态sql

#### 动态sql就是根据不同的条件去生成不同的sql语句

#### 所谓的动态sql,本质上还是sql语句,只是我们可以在sql层面,去执行一个逻辑代码

#### **动态SQL就是在拼接SQL语句，我们只要保证SQL的正确性，按照SQL的格式，**

**去排列组合就可以了**

建议：

- 先在Mysql中写出完整的SQL，再对应的去修改成我们的动态SQL实现通用即可

### Foreach

![image-20200916212031264](MyBatis.assets/image-20200916212031264.png)

## 13、缓存

### 13.1 简介

> 查询 ： 连接数据库，耗资源
>
>  一次查询的结果，给他暂存一个可以直接取到的地方 --> 内存：缓存
>
> 我们再次查询的相同数据的时候，直接走缓存，不走数据库了

1. 什么是缓存[Cache]？
   - 存在内存中的临时数据
   - 将用户经常查询的数据放在缓存（内存）中，用户去查询数据就不用从磁盘上（关系型数据库文件）查询，从缓存中查询，从而提高查询效率，解决了高并发系统的性能问题
2. 为什么使用缓存？
   - 减少和数据库的交互次数，减少系统开销，提高系统效率
3. 什么样的数据可以使用缓存？
   - 经常查询并且不经常改变的数据 【可以使用缓存】

### 13.2 MyBatis缓存

- MyBatis包含一个非常强大的查询缓存特性，它可以非常方便的定制和配置缓存，缓存可以极大的提高查询效率。

- MyBatis系统中默认定义了两级缓存：

  一级缓存和二级缓存

  - 默认情况下，只有一级缓存开启（SqlSession级别的缓存，也称为本地缓存）
- 二级缓存需要手动开启和配置，他是基于namespace级别的缓存。
  - 为了提高可扩展性，MyBatis定义了缓存接口Cache。我们可以通过实现Cache接口来定义二级缓存。

### 13.3 一级缓存

- 一级缓存也叫本地缓存：SqlSession
  - 与数据库同一次会话期间查询到的数据会放在本地缓存中
  - 以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库

测试步骤：

1. 开启日志

2. 测试在一个Session中查询两次记录

   ```java
       @Test
       public void test1() {
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           User user = mapper.getUserById(1);
           System.out.println(user);
   
           System.out.println("=====================================");
   
           User user2 =  mapper.getUserById(1);
           System.out.println(user2 == user);
       }
   ```

3. 查看日志输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165129955.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

**缓存失效的情况：**

1. 查询不同的东西

2. 增删改操作，可能会改变原来的数据，所以必定会刷新缓存

3. 查询不同的Mapper.xml

4. 手动清理缓存

   ```java
   sqlSession.clearCache();
   ```

一级缓存默认是开启的,只在一个sqlsession中有效 也就是拿到这个连接且关闭它之前的这段时间内

### 13.4 二级缓存

- 二级缓存也叫全局缓存，一级缓存作用域太低了，所以诞生了二级缓存
- 基于namespace级别的缓存，一个名称空间，对应一个二级缓存
- 工作机制
  - 一个会话查询一条数据，这个数据就会被放在当前会话的一级缓存中
  - 如果会话关闭了，这个会员对应的一级缓存就没了；但是我们想要的是，会话关闭了，一级缓存中的数据被保存到二级缓存中
  - 新的会话查询信息，就可以从二级缓存中获取内容
  - 不同的mapper查询出的数据会放在自己对应的缓存（map）中

一级缓存开启（SqlSession级别的缓存，也称为本地缓存）

- 二级缓存需要手动开启和配置，他是基于namespace级别的缓存。
- 为了提高可扩展性，MyBatis定义了缓存接口Cache。我们可以通过实现Cache接口来定义二级缓存。

步骤：

1. 开启全局缓存

   ```xml
   <!--显示的开启全局缓存-->
   <setting name="cacheEnabled" value="true"/>
   ```

2. 在Mapper.xml中使用缓存

   ```xml
   <!--在当前Mapper.xml中使用二级缓存-->
   <cache
          eviction="FIFO"
          flushInterval="60000"
          size="512"
          readOnly="true"/>
   ```

3. 测试

   1. 问题：我们需要将实体类序列化，否则就会报错

**小结：**

- 只要开启了二级缓存，在同一个Mapper下就有效
- 所有的数据都会放在一级缓存中
- 只有当前会话提交，或者关闭的时候，才会提交到二级缓存中

### 13.5 缓存原理

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165404113.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70#pic_center)

**注意：**

- 只有查询才有缓存，根据数据是否需要缓存（修改是否频繁选择是否开启）useCache=“true”

  ```xml
      <select id="getUserById" resultType="user" useCache="true">
          select * from user where id = #{id}
      </select>
  ```

### 13.6 自定义缓存-ehcache

> Ehcache是一种广泛使用的开源Java分布式缓存。主要面向通用缓存

1. 导包

   ```xml
   <dependency>
       <groupId>org.mybatis.caches</groupId>
       <artifactId>mybatis-ehcache</artifactId>
       <version>1.2.1</version>
   </dependency>
   12345
   ```

2. 在mapper中指定使用我们的ehcache缓存实现

   ```xml
   <cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
   ```




