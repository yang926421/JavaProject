package cn.gsxt.dao.impl;

import cn.gsxt.dao.provinceDao;
import cn.gsxt.domain.Province;
import cn.gsxt.jedis.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class provinceDaoImpl implements provinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //使用sql语句去查询
        String sql = "select * from province";
        //
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
