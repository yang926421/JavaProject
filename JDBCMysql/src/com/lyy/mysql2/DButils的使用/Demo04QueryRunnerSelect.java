package com.lyy.mysql2.DButils的使用;

import domain.users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import utlis.DruidUtils;

import java.sql.Connection;
import java.util.List;

/**
 * public <T> T	query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
 * 只能执行查询  根据需求 返回结果数据
 * 参数
 * 连接对象
 * sql语句
 * 可变参数
 * 给问号传递的值
 * ResultSetHandler<T>  结果集处理器  告诉query方法把查询结果的resultSet对象封装成什么样子的数据
 * ResultSetHandler是个接口  所以必然要传递该接口的实现类对象
 */

public class Demo04QueryRunnerSelect {
    //

    /**
     * 1.空参构造器创建类QueryRunner的对象
     * 2.通过连接池对象获取连接Connection对象
     * 3.定义sql语句,参数?代替
     * 4.核心类QueryRunner的方法query执行查询的操作获取结果,
     * 传递连接对象 传递sql语句, 传递结果集处理器ResultSetHandler的实现类对象,传递sql语句中需要的参数
     * 5.处理结果
     * 6.关闭资源
     */
    @Test
    public void queryOne() throws Exception {
        //根据uid查询一条记录,把查询结果封装成Users对象
        //结果集处理器   BeanHandler   构造方法中接收一个class对象,内部可以通过这个class对象,通过反射调set方法
        //无参构造器创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接对象
        Connection con = DruidUtils.getConnection();
        //查询数据 定义sql语句
        String sql = "select * from users_day2 where uid = ?";
        //通过queryRunner调query方法
        users user = queryRunner.query(con, sql, new BeanHandler<users>(users.class), "u001");
        /**
         内部原理
         1.传递了连接对象con, sql语句, ,传递结果集处理器resultSetHandler的实现类对象,传递sql语句?所需的参数
         2.内部可以做查询,获取到结果集ResultSet
         3.结果集处理器对象传递了class类对象,
         内部可以通过反射获取相应的对象,属性,方法,遍历结果集对象,把结果集对象封装到具体的函数中
         反射封装数据
         */
        System.out.println(user);
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
