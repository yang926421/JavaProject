package cn.gsxt.test;

import cn.gsxt.aop;
import cn.gsxt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//指定配置文件
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class springTest {

    //
    @Autowired
    private UserService userService;


    @Autowired
    private cn.gsxt.aop aop;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test2() {
        aop.run();
    }

    @Test
    public void test() throws Exception {
//         userService.save();
        System.out.println(1234);
    }

    @Test
    public void test4() {
        String sql = "";
//        jdbcTemplate.queryForObject()
    }
}
