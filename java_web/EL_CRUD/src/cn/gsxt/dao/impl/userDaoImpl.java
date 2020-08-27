package cn.gsxt.dao.impl;

import cn.gsxt.dao.userDao;
import cn.gsxt.domain.User;
import cn.gsxt.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class userDaoImpl implements userDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用jdbc连接数据库的查询
        String sql = "select * from el_user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public void addOne(User user) {
        //1.定义sql
        String sql = "insert  into el_user values(null, ?,?,?,?,?,?);";

        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());

    }
}
