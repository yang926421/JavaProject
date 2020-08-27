package cn.gsxt.dao.impl;

import cn.gsxt.dao.UserDao;
import cn.gsxt.domain.User;
import cn.gsxt.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User SelectUserByUsername(String username) {
        //连接数据库去进行查询
        User user = null;
        try {
            String sql = "select * from user_test where username = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
