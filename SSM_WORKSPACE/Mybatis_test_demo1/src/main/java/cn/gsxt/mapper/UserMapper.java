package cn.gsxt.mapper;

import cn.gsxt.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();

    public User findByUsernameAndPassword(User user);

    public List<User> findByIds(List<Integer> ids);

}
