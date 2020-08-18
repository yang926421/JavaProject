package cn.gsxt.dao.impl;

import cn.gsxt.dao.UserDao;
import cn.gsxt.domain.Role;
import cn.gsxt.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from sys_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long save(final User user) {
        final String sql = "insert into sys_user values(?, ?, ?, ?, ?)";
        //jdbcTemplate.update(sql, null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        //返回当前保存的用户的id   是数据库自动生成的   需要重新获取
        //创建preparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
               //使用原始的jdbc完成有个prepartedState组件
//                 PreparedStatement.RETURN_GENERATED_KEYS  代表返回生成主键
                PreparedStatement preparedStatement =  connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setObject(2, user.getUsername());
                preparedStatement.setObject(3, user.getEmail());
                preparedStatement.setObject(4, user.getPassword());
                preparedStatement.setObject(5, user.getPhoneNum());
                return preparedStatement;
            }
        };

        //创建keyHolder,通过keyHolder可以获取生成的组件
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        //通过keyholder获得生成的主键
        Long userId =  keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        //通过user对象  往sys_user_role添加数据
        String sql = "insert into sys_user_role values(?, ?)";
        for (Long roleId : roleIds) {
            jdbcTemplate.update(sql, userId, roleId);

        }

    }

    //删除用户


    @Override
    public void delUserRoleRel(Long userId) {
        String sql = "delete from sys_user_role where userId = ?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void del(Long userId) {
    String sql = "delete from sys_user where id = ?";
    jdbcTemplate.update(sql, userId);
    }

    //

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        String sql = "select * from sys_user where username = ? and password = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }
}
