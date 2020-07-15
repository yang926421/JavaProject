package utlis;

import java.sql.Connection;

public class ConnectionManager {
    /**

     数据库的连接对象管理工具类
     作用
        获取连接事务
        开启事务
        提交事务
        回滚事务
     */

    //实现单个线程中共享链接资源
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    private ConnectionManager(){

    }
    //定义静态方法,获取连接对象,保证在同一个线程中获取的是同一个连接对象
    public static Connection getConnection() throws Exception{
        //从threadLocal获取连接对象
        Connection con = tl.get();
        //判断con的值是否是null
        // 如果是null 说明之前没有绑定connection对象
        if(con == null)
        {
            //从连接池中获取对象
            con = DruidUtils.getConnection();
            //获取之后要绑定
            tl.set(con);
        }
        return con;
    }
    //定义静态方法, 开启事务
    public  static void begin() throws Exception{
        //获取连接对象
        Connection con = getConnection();
        con.setAutoCommit(false);
    }

    //定义静态方法, 提交事务
    public  static void commit() throws Exception{
        //获取连接对象
        Connection con = getConnection();
        con.commit();
    }

    //定义静态方法, 回滚事务
    public  static void rollback() throws Exception{
        //获取连接对象
        Connection con = getConnection();
        con.rollback();
    }

    public static void release() throws Exception{
        Connection con = getConnection();
        con.close();
        tl.remove();

    }


}
