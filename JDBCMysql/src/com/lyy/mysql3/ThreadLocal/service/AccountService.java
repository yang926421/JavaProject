package com.lyy.mysql3.ThreadLocal.service;

import com.lyy.mysql3.ThreadLocal.dao.AccountDao;
import utlis.ConnectionManager;

public class AccountService {
    /**
     在service层定义AccountService类
     转账方法
        transfer(转账金额,入账账户,出账账户){
            创建accountDao类的对象
            调用方法in out

     }
        参数由view层传递,但是连接对象由service层创建, 一个事务必须使用一个 connection对象
     事务也由service处理
     */
    public void transfer(double money, String inName, String outName){
        try{
            //2开启事务
            ConnectionManager.begin();
            //3.创建dao层类对象
            AccountDao dao = new AccountDao();
            //调用in,out对象
            dao.out(money, outName);
            dao.in(money,inName);
            //没有异常,提交事务
            ConnectionManager.commit();
            //提示转账成功
            System.out.println("转账成功");
        }
        catch(Exception e){
            try {
                ConnectionManager.rollback();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        finally{
            try {
                ConnectionManager.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
