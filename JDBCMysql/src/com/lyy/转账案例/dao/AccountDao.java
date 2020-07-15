
package com.lyy.转账案例.dao;

        import org.apache.commons.dbutils.QueryRunner;

        import java.sql.Connection;

/**
 在dao层定义AccountDao类
 入账方法
 in(连接对象,入账金额,入账账户)
 创建queryrunner  sql语句, 调用update
 出
 out(...)
 以上参数由业务处理层传递

 不负责事务管理  有异常抛给service层


 */

public class AccountDao {

    public void in(Connection con, double inMoney, String inName)throws Exception{
        //创建queryRunner
        QueryRunner queryRunner = new QueryRunner();
        //连接对象由别人传递
        String inSql = "update account set money = money +  ? where name = ?";
        queryRunner.update(con, inSql, inMoney, inName);

    }

    public void out(Connection con, double outMoney, String outName)throws Exception{
        //创建queryRunner
        QueryRunner queryRunner = new QueryRunner();
        //连接对象由别人传递
        String outSql = "update account set money = money - ? where name = ?";
        System.out.println(con);
        System.out.println(outMoney);
        System.out.println(outSql);
        System.out.println(outName);
        queryRunner.update(con, outSql, outMoney, outName);
        System.out.println(234);

    }

}

