package com.lyy.mysql2.mysql事务;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utlis.DruidUtils;

import java.sql.Connection;

/**
 完成转账不使用事务
 tom和Jerry都有10000
 tom欠jerry1000
 */
public class Demo01Account {

    public static void main(String[] args) throws Exception{
        QueryRunner queryRunner = new QueryRunner();
        Connection con = DruidUtils.getConnection();
        //定义sql语句
        // tom扣款
        String tomSql = "update account set money = money - ? where name = ?";
        //jerry加钱
        String jerrySql = "update account set money = money+? where name = ?";

        int tomResult = queryRunner.update(con, tomSql, 1000, "tom");
        if (tomResult>0){
            System.out.println("tom扣款成功");
        }
        else System.out.println("tom扣款失败");
        //如果在这里出现运行时报错 就会出现扣款成功,没有加款,,引入事务处理概念
        //因为一条sql一个事务
        int jerryResult = queryRunner.update(con, jerrySql, 1000, "jerry");
        if (jerryResult>0){
            System.out.println("加款成功");
        }
        else System.out.println("加款失败");

        DruidUtils.release(con, null, null);

    }

}
