package cn.gsxt.dao;

import cn.gsxt.domain.User;

import java.util.List;

//动态sql语句的实现
public interface UserMapper1 {
    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);

    public void save(User user);

    public User findById(int id);

    //查询全部
    public List<User> findAll();
}
