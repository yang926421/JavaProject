package utlis;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 定义JDBC 工具类  作用 获取连接对象
 * JDBC工具类的特点
 * 1.构造方法private修饰
 * 2.所有的方法都是static修饰
 */
public class JDBCUtils01 {
    //构造方法私有
    private JDBCUtils01() {

    }

    //静态方法获取Connection对象
    public static Connection getConnection() throws Exception {
        // 1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取connection连接对象
        String url = "jdbc:mysql://localhost:3306/jdbc_mysql1";
        String user = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

}
