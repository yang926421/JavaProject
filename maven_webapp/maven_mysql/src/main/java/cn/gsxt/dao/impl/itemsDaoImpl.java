package cn.gsxt.dao.impl;

import cn.gsxt.damain.items;
import cn.gsxt.dao.itemsDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class itemsDaoImpl implements itemsDao {
    public List<items> findAll() throws Exception{
            List<items> list = new ArrayList<items>();
            //先获取contection对象
            Connection connection = null;
            //获取真正操作数据的对象
            PreparedStatement pst = null;
            //执行数据库查询操作
            ResultSet rs = null;
            try {
                //加载驱动类
                Class.forName("com.mysql.jdbc.Driver");
                //先获取contection对象
                connection = DriverManager.getConnection("jdbc:mysql:///jdbc_mysql1","root", "123");
                //获取真正操作数据的对象
                pst = connection.prepareCall("select * from el_user");
                //执行数据库查询操作
                rs = pst.executeQuery();
                //把数据库结果集转成java的List集合

                while (rs.next()){
                    items items = new items();
                    items.setId(rs.getInt("id"));
                    items.setName(rs.getString("name"));
                    list.add(items);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                connection.close();
                pst.close();
                rs.close();
            }

            return list;
        }
}
