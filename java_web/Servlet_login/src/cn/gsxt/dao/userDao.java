package cn.gsxt.dao;

import cn.gsxt.domain.user;

import cn.gsxt.utils.JDBCUtils;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
////import org.springframework.jdbc.core.JdbcTemplate;

import cn.gsxt.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;


/**
 * 操纵数据库层
 */
public class userDao {
    //声明JDBCTemplate对象共用
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据, 没有查询到，返回null
     */

//    //声明JDBCTemplate对象共用
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//
//    /**
//     * 登录方法
//     * @param loginUser 只有用户名和密码
//     * @return user包含用户全部数据,没有查询到，返回null
//     */

//    public user login(user loginUser){
//        try {
//            //1.编写sql
//            String sql = "select * from users where username = ? and password = ?";
//            //2.调用query方法
//            user user1 = template.queryForObject(sql,
//                    new BeanPropertyRowMapper<user>(user.class),
//                    loginUser.getUsername(), loginUser.getPassword());
//
//
//            return user1;
//        } catch (DataAccessException e) {
//            e.printStackTrace();//记录日志
//            return null;
//        }

//    }
//
//    public void demo1(){
//        System.out.println("卧槽 为什么啊");
//    }
//    static {
//        System.out.println(11111);

//    }
//
//    public void demo1(){
//        System.out.println("卧槽 为什么啊");
//    }
    static {
        System.out.println(11111);
    }

    //用户登陆 返回一个user对象
    public user login(user LoginUser) {
        try {
            System.out.println(22222);
            //使用dbutils下的queryRunner类
            QueryRunner queryRunner = new QueryRunner();
            System.out.println(3333);
            String sql = "select * from users where username = ? and password = ?";
            System.out.println(4444);
            Connection con = DruidUtils.getConnection();
            System.out.println(LoginUser.getUsername());
            System.out.println(LoginUser.getPassword());
            user result_user = queryRunner.query(con, sql, new BeanHandler<user>(user.class), LoginUser.getUsername(), LoginUser.getPassword());
            return result_user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;  //如果没有查询出来在此返回null
        }
    }
}
