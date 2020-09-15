package cn.gsxt.service;


import cn.gsxt.mapper.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {


    @Autowired
    private userDao userDao;

    public void save() {
        System.out.println("save running....");
    }
}
