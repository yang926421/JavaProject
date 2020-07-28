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
        String sql = "insert  into el_user values(null, ?,?,?,?,?,?,null,null );" ;

        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from el_user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delUserById(int parseInt) {
        String sql = "delete from el_user where id = ?";
        template.update(sql, parseInt);
    }

    @Override
    public User findUserById(int parseInt) {
        String sql = "select * from el_user where id = ?";
        return  template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), parseInt);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update el_user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());

    }

    @Override
    public int findUsersCount() {
        //查询所有的记录数
        String sql = "select count(*) from el_user";
        return  template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql = "select * from el_user limit ?, ? ";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class),start,rows );
    }
}
