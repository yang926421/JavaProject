package cn.gsxt.test;

import cn.gsxt.dao.userDao;
import cn.gsxt.domain.user;
import org.junit.Test;

public class userDaoTest {
    @Test
    public void testLogin() {
        user loginUser1 = new user();
        loginUser1.setUsername("admin");
        loginUser1.setPassword("123456");

        userDao dao = new userDao();
        user user_really = null;
        try {
            user_really = dao.login(loginUser1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user_really);
    }
}
