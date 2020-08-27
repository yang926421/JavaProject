package com.lyy.mysql2.测试;

public class data {
    /**
     给数据库表users创建对应的javaBean类 users
     1.根据uid查询获取一个users对象
     2.查询所有记录1,每个记录对应一个users对象,存储list集合  list<users>

     实现步骤
     1.创建javabean类
     2.通过连接池对象获取连接Connection对象
     3.定义sql语句 ?代替参数
     4.执行sql语句的PreparedStatement对象
     5.给sql语句赋值
     6.执行sql语句,获取resultSet对象
     7.把结果集ResultSet对象封装成users对象
     8.关闭资源










     create table users_day2(
     uid varchar(20) primary key,
     uname varchar(32),
     upass varchar(32));

     准备数据
     insert into users_day2(uid, uname, upass) values('u001', 'admin','123456');
     insert into users_day2(uid, uname, upass) values('u002', 'admin2','123456');
     insert into users_day2(uid, uname, upass) values('u003', 'admin3','123456');
     insert into users_day2(uid, uname, upass) values('u004', 'admin4','123456');
     */
}
