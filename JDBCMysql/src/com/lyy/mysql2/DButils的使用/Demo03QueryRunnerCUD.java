package com.lyy.mysql2.DButils的使用;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utlis.DruidUtils;

import java.sql.Connection;

public class Demo03QueryRunnerCUD {
    /**
     核心类QueryRunner:
     有参构造器 直接创建对象
     public QueryRunner(DataSource ds):有参构造器,创建对象需要传递连接池对象
     ds连接池接口 传递实现类  c3p0  druid

     使用有参构造器创建对象 会传递连接池对象 所以后续再执行增删改查方法的同时,不需要再传递连接对象

     类下有方法
     public int update( String sql, Object...params)
     只能执行增删改   返回int 指处理的数据  后面的可变参数指的是为sql语句?赋值

     * 有参构造器queryRunner来操作数据库
     * 步骤
     * 1.空参构造器创建queryRunner对象
     * 2.定义sql语句
     * 3.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
     * 4.处理结果
     * 5.关闭资源

     */
    @Test
    public void addUsers() throws Exception{
//        1.空参构造器创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        2.定义sql语句s
        String sql = "insert into users_day2(uid, uname, upass) values(?,?,?);";
//        3.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
        int result = queryRunner.update(sql, "u005", "admin5", "123456");
//        4.处理结果
        if (result > 0){
            System.out.println("添加成功");
        }
        else System.out.println("添加失败");
    }

    //修改一条数据
    @Test
    public void editUsers() throws Exception{
//        1.空参构造器创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        2.定义sql语句s
        String sql = "update users_day2 set uname = ?, upass = ? where uid = ?;";
//        3.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
        int result = queryRunner.update( sql, "root", "root2", "u005");
//        4.处理结果
        if (result > 0){
            System.out.println("修改成功");
        }
        else System.out.println("修改失败");
    }


    //删除一条数据
    @Test
    public void deleteUsers() throws Exception{
//        1.空参构造器创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        3.定义sql语句s
        String sql = "delete from users_day2 where uid = ?";
//        4.核心类调用update方法执行sql语句,传递连接对象传递sql语句,给?号赋值
        int result = queryRunner.update(sql,  "u005");
//        5.处理结果
        if (result > 0){
            System.out.println("删除成功");
        }
        else System.out.println("删除失败");
    }

}
