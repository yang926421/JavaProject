package cn.gsxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    public List<Map<String, Object>> query(){
        String sql = "select * from tx_user";
        List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql);
        System.out.println(queryForList);
        return queryForList;
    }
}
