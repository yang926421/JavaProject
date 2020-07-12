package utlis;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 定义JDBC 工具类  作用 获取连接对象
 JDBC工具类的特点
    1.构造方法private修饰
    2.所有的方法都是static修饰


 */
public class JDBCUtils02 {
    //构造方法私有
    private JDBCUtils02(){

    }
    //讲dbcutil01是属于每次都要执行注册驱动  定义等信息
    //2.获取connection连接对象
    private static String url = "jdbc:mysql://localhost:3306/jdbc_mysql1";
    private static String user = "root";
    private static String password = "123";
    //定义驱动类名
    private static String driverClassName = "com.mysql.jdbc.Driver";
    static{
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //静态方法获取Connection对象
    public static Connection getConnection() throws Exception{
        //获取连接对象
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

}
