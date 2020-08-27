package cn.gsxt.dao.impl;

import cn.gsxt.dao.RoleDao;
import cn.gsxt.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        System.out.println("roleDao");
        String sql = "select * from sys_role";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        System.out.println(roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
//        jdbc来操作
        String sql = "insert into sys_role values(?,?,?)";
        jdbcTemplate.update(sql, null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        String sql = "select * from sys_user_role ur, sys_role r where ur.roleId=r.id and ur.userId = ?";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class), id);
        return roleList;
    }
}
