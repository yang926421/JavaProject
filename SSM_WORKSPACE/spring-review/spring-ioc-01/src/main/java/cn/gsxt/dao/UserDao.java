package cn.gsxt.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UserDao {
    private static String nums = "123";
    public void findAll(){
        System.out.println("我可以单独使用呀");
    };
}
