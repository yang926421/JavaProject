package cn.gsxt.service.impl;

import cn.gsxt.dao.UserDao;
import cn.gsxt.dao.impl.UserDaoImpl;
import cn.gsxt.domain.User;
import cn.gsxt.service.UserService;

public class userServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    @Override
    public User SelectUserByUsername(String username) {
        return dao.SelectUserByUsername(username);
    }
}
