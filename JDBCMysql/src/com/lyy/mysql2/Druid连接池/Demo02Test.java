package com.lyy.mysql2.Druid连接池;

import utlis.DruidUtils;

import java.sql.Connection;

public class Demo02Test {
    public static void main(String[] args) throws Exception{
        Connection con = DruidUtils.getConnection();
    }
}
