package cn.gsxt.service.impl;

import cn.gsxt.mapper.UserDao;
import cn.gsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


//<bean id="userService" class="cn.gsxt.service.impl.UserServiceImpl" ></bean>
//@Component("userService")
@Service("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
    @Autowired //按照数据类型从Spring容器中进行配置,如果只有这一个参数,  spring扫描的时候会直接在spring容器中找有没有一个userDao的bean,如果有则直接注入到这里
    @Qualifier("userDao")//这两个注解相当于xml的依赖注入    按照id的值从容器中进行匹配
//    @Resource(name="userDao")   相当于 Autowired + Qualifier
    private UserDao userDao;

    //    @Value("我是lyy")  鸡肋不用
    @Value("${jdbc.driver}") //xml配置文件已加载properties
    private String lyy;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        userDao.save();
//        System.out.println(lyy);
    }
}
