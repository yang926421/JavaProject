package com.lyy.mysql2.DButils的使用;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utlis.DruidUtils;

import java.sql.Connection;

public class Demo01QueryRunnerCUD {
    /**
     * 使用queryRunner来操作数据库
     * 步骤
     * 1.空参构造器创建queryRunner对象
     * 2.使用Druid创建连接对象
     * 3.定义sql语句
     * 4.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
     * 5.处理结果
     * 6.关闭资源
     */
    @Test
    public void addUsers() throws Exception {
//        1.空参构造器创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
//        2.使用Druid创建连接对象
        Connection con = DruidUtils.getConnection();
//        3.定义sql语句s
        String sql = "insert into users_day2(uid, uname, upass) values(?,?,?);";
//        4.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
        int result = queryRunner.update(con, sql, "u005", "admin5", "123456");
//        5.处理结果
        if (result > 0) {
            System.out.println("添加成功");
        } else System.out.println("添加失败");
//        6.关闭资源
        DruidUtils.release(con, null, null);
    }

    //修改一条数据
    @Test
    public void editUsers() throws Exception {
//        1.空参构造器创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
//        2.使用Druid创建连接对象
        Connection con = DruidUtils.getConnection();
//        3.定义sql语句s
        String sql = "update users_day2 set uname = ?, upass = ? where uid = ?;";
//        4.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
        int result = queryRunner.update(con, sql, "root", "root2", "u005");
//        5.处理结果
        if (result > 0) {
            System.out.println("修改成功");
        } else System.out.println("修改失败");
//        6.关闭资源
        DruidUtils.release(con, null, null);
    }


    //修改一条数据
    @Test
    public void dropUsers() throws Exception {
//        1.空参构造器创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
//        2.使用Druid创建连接对象
        Connection con = DruidUtils.getConnection();
//        3.定义sql语句s
        String sql = "delete from users_day2 where uid = ?";
//        4.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
        int result = queryRunner.update(con, sql, "u005");
//        5.处理结果
        if (result > 0) {
            System.out.println("删除成功");
        } else System.out.println("删除失败");
//        6.关闭资源
        DruidUtils.release(con, null, null);
    }

}
