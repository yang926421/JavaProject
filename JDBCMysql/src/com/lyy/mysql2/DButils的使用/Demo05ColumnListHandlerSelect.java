package com.lyy.mysql2.DButils的使用;

import domain.users;
import org.apache.commons.dbutils.ColumnHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import utlis.DruidUtils;

import java.sql.Connection;
import java.util.List;

/**
 * ColumnListHandler
 * 查询一列的数据返回list集合
 * 结果集处理器  ColumnsListHandlers
 * 作用  获取的是单一结果(只有一个数据)主要应用场景,聚合函数
 * public ColumnListHandler()  获取第一列对应的list集合
 * public ColumnListHandler(int index)
 * public ColumnListHandler(String name)
 */

public class Demo05ColumnListHandlerSelect {


    @Test
    public void queryOne() throws Exception {

        QueryRunner queryRunner = new QueryRunner();
        //创建连接对象
        Connection con = DruidUtils.getConnection();
        //查询数据 定义sql语句
        String sql = "select * from users_day2";
        //通过queryRunner调query方法
        List object = queryRunner.query(con, sql, new ColumnListHandler<>());
        /**
         内部原理
         1.传递了连接对象con, sql语句, ,传递结果集处理器resultSetHandler的实现类对象,传递sql语句?所需的参数
         2.内部可以做查询,获取到结果集ResultSet
         3.结果集处理器对象传递了class类对象,
         内部可以通过反射获取相应的对象,属性,方法,遍历结果集对象,把结果集对象封装到具体的函数中
         反射封装数据
         */
        object.forEach(System.out::println);
        DruidUtils.release(con, null, null);
    }

    @Test
    public void queryAll() throws Exception {
        //根据uid查询一条记录,把查询结果封装成Users对象
        //结果集处理器   BeanHandler   构造方法中接收一个class对象,内部可以通过这个class对象,通过反射调set方法
        //无参构造器创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接对象
        Connection con = DruidUtils.getConnection();
        //查询数据 定义sql语句
        String sql = "select * from users_day2";

        //通过queryRunner调query方法
        List<users> user = queryRunner.query(con, sql, new BeanListHandler<users>(users.class));
        /**
         内部原理
         1.传递了连接对象con, sql语句, ,传递结果集处理器resultSetHandler的实现类对象,传递sql语句?所需的参数
         2.内部可以做查询,获取到结果集ResultSet
         3.结果集处理器对象传递了class类对象,
         内部可以先创建list集合,通过反射获取相应的对象,属性,方法,遍历结果集对象,把结果集对象封装到具体的函数中
         反射封装数据
         */
        for (users users : user) {
            System.out.println(users);
        }
        DruidUtils.release(con, null, null);
    }
}
