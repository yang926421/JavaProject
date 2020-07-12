package com.lyy.mysql._02JDBC使用工具类;

import org.junit.Test;
import utlis.JDBCUtilsFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class jdbcIoException {
    //给数据库添加一条数据
    @Test
    public void queryOne() {
        //提升变量的作用域
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtilsFinal.getConnection();
            //准备sql语句
            String sql = "select * from users where uid = ?";
            //获取执行sql语句的对象
            pstmt = con.prepareStatement(sql);
            //给sql语句的?添加值
            pstmt.setInt(1, 1);
            //获取执行的结果集
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("查询到这条数据了");
                int uid = resultSet.getInt(1);
                //根据列名查询到第二列的值
                String username = resultSet.getString("username");
                Object password1 = resultSet.getObject("password");
                System.out.println(uid);
                System.out.println(username);
                System.out.println(password1);
            } else System.out.println("没有查询到数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //这样写太麻烦了 封装到类中去
            JDBCUtilsFinal.release(con, pstmt, resultSet);
//            //关闭资源
//            if(con != null){
//            try {
//
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }}
//            if(pstmt != null){
//            try {
//                pstmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }}
//            if(resultSet!=null){
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }}
        }

    }

    //
    @Test
    public void queryAll() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            //1.注册驱动
            con = JDBCUtilsFinal.getConnection();
            //准备sql语句
            String sql = "select * from users";
            //获取执行sql语句的对象
            pstmt = con.prepareStatement(sql);
            //sql语句 没有问号 不用赋值
            //获取执行的结果集
            resultSet = pstmt.executeQuery();
            System.out.println("查询到数据了");
            while (resultSet.next()) {
                int uid = resultSet.getInt(1);
                //根据列名查询到第二列的值
                String username = resultSet.getString("username");
                Object password2 = resultSet.getObject("password");
                System.out.println(uid);
                System.out.println(username);
                System.out.println(password2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsFinal.release(con, pstmt, resultSet);
        }
    }
}
