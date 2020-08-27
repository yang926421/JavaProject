package utlis;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装C3P0连接池工具类获取连接对象
 * 特点
 * 1.构造方法private修饰
 * 2.所有的方法都是static修饰的
 */
public class C3P0Utils {
    /**
     * 创建连接池对象
     * 内部自动读取配置文件
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    //    1.构造方法private修饰
    private C3P0Utils() {
    }

    //定义静态方法  获取连接对象
    public static Connection getConnection() throws Exception {
        //如果是有配置文件  然后又进行java硬编码set设置  name之前的配置文件就作废
        //获取连接对象
        Connection con = cpds.getConnection();
        return con;
    }

    //定义静态方法  获取连接池对象
    public static DataSource getDataSource() {
        return cpds;
    }

    //关闭静态资源,但是关闭的时候调用的close方法是C3p重写过的方法 是把连接对象返回到连接池中重复使用
    public static void release(Connection con, PreparedStatement pstmt, ResultSet resultSet) {
        //关闭资源
        if (con != null) {
            try {

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
