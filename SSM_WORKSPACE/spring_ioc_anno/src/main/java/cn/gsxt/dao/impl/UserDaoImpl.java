package cn.gsxt.dao.impl;

import cn.gsxt.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="cn.gsxt.dao.impl.UserDaoImpl"></bean>
//@Component("userDao")//注解替代上面的xml
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running");
    }
}
