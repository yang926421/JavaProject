package com.lyy.转账案例.service;

import com.lyy.转账案例.dao.AccountDao;
import utlis.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    /**
     * 在service层定义AccountService类
     * 转账方法
     * transfer(转账金额,入账账户,出账账户){
     * 创建accountDao类的对象
     * 调用方法in out
     * <p>
     * }
     * 参数由view层传递,但是连接对象由service层创建, 一个事务必须使用一个 connection对象
     * 事务也由service处理
     */
    public void transfer(double money, String inName, String outName) {
        Connection con = null;
        try {
            //1获取连接对象
            con = DruidUtils.getConnection();
            //2开启事务
            con.setAutoCommit(false);
            //3.创建dao层类对象
            AccountDao dao = new AccountDao();
            //调用in,out对象
            dao.out(con, money, outName);
            dao.in(con, money, inName);
            System.out.println(con);
            System.out.println(money);
            System.out.println(inName);
            System.out.println(outName);
            //没有异常,提交事务
            con.commit();
            //提示转账成功
            System.out.println("转账成功");
        } catch (Exception e) {
            //获取异常回滚事务
            System.out.println("转账失败");
            if (con != null)
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
        } finally {
            DruidUtils.release(con, null, null);
//            关闭资源
        }
    }
}
