//package cn.gsxt.dao.impl;
//
//
//import cn.gsxt.dao.AccountDao;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class AccountDaoImpl implements AccountDao {
//
//    private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void out(String outMan, double money) {
//        jdbcTemplate.update("update account set money=money-? where name=?",money,outMan);
//    }
//
//    public void in(String inMan, double money) {
//        jdbcTemplate.update("update account set money=money+? where name=?",money,inMan);
//    }
//}


package cn.gsxt.dao.impl;


import cn.gsxt.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?", money, outMan);
    }

    public void in(String inMan, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?", money, inMan);
    }
}
