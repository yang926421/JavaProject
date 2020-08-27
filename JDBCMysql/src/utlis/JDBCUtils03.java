package utlis;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 定义JDBC 工具类  作用 获取连接对象
 * JDBC工具类的特点
 * 1.构造方法private修饰
 * 2.所有的方法都是static修饰
 * <p>
 * JDBCUtils02的问题是属于把所有的东西都写死了  例如连接mysql数据库 连接root等信息
 * 读取配置文件,加载信息
 */
public class JDBCUtils03 {
    //构造方法私有
    private JDBCUtils03() {

    }

    //讲dbcutil01是属于每次都要执行注册驱动  定义等信息
    //2.获取connection连接对象
    private static String url;
    private static String user;
    private static String password;
    //定义驱动类名
    private static String driverClassName;

    static {
        try {
            //读取配置文件
            Properties properties = new Properties();
            InputStream is = JDBCUtils03.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(is);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driverClassName = properties.getProperty("driverClassName");

            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //静态方法获取Connection对象
    public static Connection getConnection() throws Exception {
        //获取连接对象
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

}
