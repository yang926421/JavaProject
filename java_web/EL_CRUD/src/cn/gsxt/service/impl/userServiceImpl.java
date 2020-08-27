package cn.gsxt.service.impl;

import cn.gsxt.dao.impl.userDaoImpl;
import cn.gsxt.dao.userDao;
import cn.gsxt.domain.User;
import cn.gsxt.service.userService;

import java.util.List;

public class userServiceImpl implements userService {
    private userDao dao = new userDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao来完成查询
        return dao.findAll();
    }

    @Override
    public void addOne(User user) {
        dao.addOne(user);
    }
}
