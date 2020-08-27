package utlis;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lyy.mysql2.Druid连接池.Demo01Druid;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 封装Druid连接池工具类获取连接对象
 * 特点
 * 1.构造方法private修饰
 * 2.所有的方法都是static修饰的
 */
public class DruidUtils {
    /**
     * 创建连接池对象
     * 内部自动读取配置文件
     */

    //    1.构造方法private修饰
    private DruidUtils() {
    }

    private static DataSource druidDataSource = null;

    static {
        try {
            Properties pros = new Properties();
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //把配置文件信息加载到properties集合对象中
            pros.load(is);
            //        ResourceBundle resourceBundle = ResourceBundle.getBundle("druid.properties");
            druidDataSource = DruidDataSourceFactory.createDataSource(pros);
            System.out.println(druidDataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //定义静态方法  获取连接对象
    public static Connection getConnection() throws Exception {
        //druidDataSource连接池对象来获取连接
        Connection con = druidDataSource.getConnection();
        System.out.println(con);
        return con;

    }

    //定义静态方法  获取连接池对象
    public static DataSource getDataSource() {
        return druidDataSource;
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
