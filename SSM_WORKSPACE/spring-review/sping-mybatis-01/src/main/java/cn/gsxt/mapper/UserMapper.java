package cn.gsxt.mapper;

import cn.gsxt.module.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {


    public List<User> getAllUsers();
}
