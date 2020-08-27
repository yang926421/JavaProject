package cn.gsxt.test;

import cn.gsxt.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Jdbc_test {

    @Autowired
    /*按照数据类型从Spring容器中进行配置,如果只有这一个参数,  s
    pring扫描的时候会直接在spring容器中找有没有一个 jdbcTemplate的bean,如果有则直接注入到这里
    */
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        int row = jdbcTemplate.update("insert into account values(?,?)", "lisi", 5000);
        System.out.println(row);
    }

    @Test
    public void test2() {
        String sql = "select * from account where name= ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(account);
    }

}
