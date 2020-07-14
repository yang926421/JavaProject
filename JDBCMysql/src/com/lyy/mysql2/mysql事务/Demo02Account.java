package com.lyy.mysql2.mysql事务;

import org.apache.commons.dbutils.QueryRunner;
import utlis.DruidUtils;

import java.sql.Connection;

/**
    通过事务处理
 把两条sql放在一个事务中,应该被看成一个整体,必须保证在一个事务里完成,必须使用同一个连接Connection连接对象
 tom和Jerry都有10000
 tom欠jerry1000
 事务管理流程
    begin
    执行sql如果没问题 commit  有问题回滚事务 把数据回退到开启事务之前
 jdbc事务的方法 都在Connection类的方法
    setAutoCommit(boolean);将此连接自动提交设置为给定状态  true自动 false手动
    commit  使所有上一次提交/回滚后的更改持久化,释放此connection对象的所有数据库锁
    rollback 回滚  数据库也是通过锁的机制


 事务管理的代码格式 应该放在 try  catch
 try{
 1.空参构造器创建核心类QueryRunner对象
 2.连接池对象获取connection对象
 3.开启事务
 4.定义sql语句
 5.执行sql
 6.无异常 提交事务

 }
 catch(Exception e){
    有异常,回滚事务
 }
 finally{
 关闭资源
 }
 */
public class Demo02Account {
    private static Connection con = null;
    public static void main(String[] args) throws Exception{
        try{
//            1.空参构造器创建核心类QueryRunner对象
            QueryRunner queryRunner = new QueryRunner();
//            2.连接池对象获取connection对象
            con = DruidUtils.getConnection();
//            3.开启事务
            con.setAutoCommit(false);
//            4.定义sql语句
            String tomSql = "update account set money = money - ? where name = ?";
            //jerry加钱
            String jerrySql = "update account set money = money+? where name = ?";

//            5.执行sql
            int tomResult = queryRunner.update(con, tomSql, 1000, "tom");
            if (tomResult>0){
                System.out.println("tom扣款成功");
            }
            else System.out.println("tom扣款失败");
            //如果在这里出现运行时报错 就会出现扣款成功,没有加款,,引入事务处理概念
            System.out.println(1/0);
            int jerryResult = queryRunner.update(con, jerrySql, 1000, "jerry");
            if (jerryResult>0){
                System.out.println("加款成功");
            }
            else System.out.println("加款失败");
//            6.无异常 提交事务
            con.commit();

        }
        catch(Exception e){
//            有异常,回滚事务
        if(con!=null){
            try{
                con.rollback();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        }
        finally{
            DruidUtils.release(con, null, null);
        }
    }

}
