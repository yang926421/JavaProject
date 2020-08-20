package cn.gsxt.dao;

import cn.gsxt.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws IOException;

//    根据Id查询
    public User findById(int id);
}
