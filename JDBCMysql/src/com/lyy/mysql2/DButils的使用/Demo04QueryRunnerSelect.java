package com.lyy.mysql2.DButils的使用;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utlis.DruidUtils;

import java.sql.Connection;
/**
 public <T> T	query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
 只能执行查询  根据需求 返回结果数据
 参数
    连接对象
    sql语句
    可变参数
        给问号传递的值
    ResultSetHandler<T>  结果集处理器  告诉query方法把查询结果的resultSet对象封装成什么样子的数据

 */

public class Demo04QueryRunnerSelect {
    //
    @Test
    public void queryOne(){
        //无参构造器创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接对象
        Connection con = DruidUtils.getConnection();

        //查询数据 定义sql语句

    }
}
