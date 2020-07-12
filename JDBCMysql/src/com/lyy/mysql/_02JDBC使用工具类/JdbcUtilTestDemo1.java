package com.lyy.mysql._02JDBC使用工具类;

import utlis.JDBCUtils01;
import utlis.JDBCUtils02;
import utlis.JDBCUtils03;
import utlis.JDBCUtilsFinal;

import java.sql.Connection;

public class JdbcUtilTestDemo1 {
    public static void main(String[] args) throws Exception  {
//        Connection con = JDBCUtils01.getConnection();
//        System.out.println(con);
//        Connection con = JDBCUtils02.getConnection();
//        System.out.println(con);

//        Connection con = JDBCUtils03.getConnection();
//        System.out.println(con);

        Connection con = JDBCUtilsFinal.getConnection();
        System.out.println(con);

    }
}
