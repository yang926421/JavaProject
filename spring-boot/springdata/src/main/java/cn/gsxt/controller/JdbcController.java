package cn.gsxt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/accountList")
    public List<Map<String, Object>> accountList(){
        //查询数据库的所有信息
        String sql = "select * from account";
        List<Map<String, Object>> account_maps = jdbcTemplate.queryForList(sql);
        return account_maps;
    }



}
