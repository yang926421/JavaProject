package cn.gsxt.service.impl;
import cn.gsxt.dao.impl.userDaoImpl;
import cn.gsxt.dao.userDao;
import cn.gsxt.domain.User;
import cn.gsxt.service.userService;

import java.util.List;

public class userServiceImpl implements userService {
    private userDao dao = new userDaoImpl();
    @Override
    public List<User> findAll(){
        //调用dao来完成查询
        return dao.findAll();
    }

    @Override
    public void addOne(User user) {
        dao.addOne(user);
    }

    @Override
    public User login(User user) {
        System.out.println(123);
        System.out.println(user.getUsername());
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void delUserById(int parseInt) {
        dao.delUserById(parseInt);
    }

    @Override
    public User findUserById(int parseInt) {

        return dao.findUserById(parseInt);
    }

    public void updateUser(User user) {
        //修改根据提交的user属性修改
        dao.updateUser(user);
    }
}
