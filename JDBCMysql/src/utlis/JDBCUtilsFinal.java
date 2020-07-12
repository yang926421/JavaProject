package utlis;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 定义JDBC 工具类  作用 获取连接对象
 JDBC工具类的特点
    1.构造方法private修饰
    2.所有的方法都是static修饰

 java.utils.ResourceBundle类: 资源管理类
 有个静态方法
    public static ResourceBundle getBundle(String baseName); 获取ResourceBundle类的对象
    参数 String baseName   只需要写文件名 不需要写扩展名
    要求 配置文件 必须写在SRC根目录下
    public String getString(String key)
        根据方法参数String类型的键去获取对应的value值
 */
public class JDBCUtilsFinal {
    //构造方法私有
    private JDBCUtilsFinal(){

    }
    //讲dbcutil01是属于每次都要执行注册驱动  定义等信息
    //2.获取connection连接对象
    private static String url;
    private static String user;
    private static String password;
    //定义驱动类名
    private static String driverClassName;
    static{
        try {
//            通过资源管理类 读取配置文件 获取信息
            //不用写properties对象 类加载器对象
            ResourceBundle rb = ResourceBundle.getBundle("config");
            url = rb.getString("url");
            user = rb.getString("user");
            password = rb.getString("password");
            driverClassName = rb.getString("driverClassName");

            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //静态方法获取Connection对象
    public static Connection getConnection() throws Exception{
        //获取连接对象
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
    public static void release(Connection con, PreparedStatement pstmt, ResultSet resultSet){
        //关闭资源
        if(con != null){
            try {

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }}
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }}
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }}
    }

}
