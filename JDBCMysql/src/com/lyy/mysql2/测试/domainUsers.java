package com.lyy.mysql2.测试;

import domain.users;
import utlis.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class domainUsers {
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
     */

    public static void main(String[] args) throws Exception{
//        users users = new users();
//        users.setUid("u001");
//        users.setUsername("admin1");
//        users.setPassword("123456");
//        System.out.println(users);

        //单个id获取
//        Scanner scanner = new Scanner(System.in);
//        String uid = scanner.nextLine();
//        users users = getUsersByUid(uid);
//        if(users == null){
//            System.out.println("没有查询出数据");
//        }
//        else  System.out.println(users);

        List<users> users1 = getUsers();
        users1.stream().forEach(System.out::println);
        //获取到全部的users
//        System.out.println(users1);

    }
    public static users getUsersByUid(String uid) throws Exception{
        //  1.创建javabean类
        //     2.通过连接池对象获取连接Conn    ection对象
        Connection con = DruidUtils.getConnection();
        //     3.定义sql语句 ?代替参数
        String sql = "select * from users_day2 where uid   = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        //     4.执行sql语句的PreparedStatement对象
        //     5.给sql语句赋值
        pstmt.setString(1,uid);
        //     6.执行sql语句,获取resultSet对象
        ResultSet resultSet = pstmt.executeQuery();
        //创建users类型的变量
        users user = null;
        //     7.把结果集ResultSet对象封装成users对象
        if(resultSet.next()){
            //获取数据
            String uid1 = resultSet.getString("uid");
            String uname = resultSet.getString("uname");
            String upass = resultSet.getString("upass");
            //把数据封装到对象中
            user = new users();
            user.setUid(uid1);
            user.setUsername(uname);
            user.setPassword(upass);
        }
        //     8.关闭资源
        DruidUtils.release(con,pstmt,resultSet);
        //返回users对象
        return user;
    }


    //查询所有数据
    public static List<users> getUsers() throws Exception{
        //  1.创建javabean类
        //     2.通过连接池对象获取连接Conn    ection对象
        Connection con = DruidUtils.getConnection();
        //     3.定义sql语句 ?代替参数
        String sql = "select * from users_day2";
        PreparedStatement pstmt = con.prepareStatement(sql);
        //     4.执行sql语句的PreparedStatement对象
        //     没有?号不需要赋值
        //     6.执行sql语句,获取resultSet对象
        ResultSet resultSet = pstmt.executeQuery();
        //创建users类型的变量
        //     7.把结果集ResultSet对象封装成list集合对象  泛型是users对象
//        创建list集合
        List<users> users1 = new ArrayList<>();
        while (resultSet.next()){
            users user = null;
            //获取数据
            String uid1 = resultSet.getString("uid");
            String uname = resultSet.getString("uname");
            String upass = resultSet.getString("upass");
            //把数据封装到对象中
            user = new users();
            user.setUid(uid1);
            user.setUsername(uname);
            user.setPassword(upass);
            users1.add(user);

        }

        //     8.关闭资源
        DruidUtils.release(con,pstmt,resultSet);
        //返回users对象
        return users1;
    }
}
