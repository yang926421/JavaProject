package cn.gsxt.mapper;

import cn.gsxt.module.Blog;
import cn.gsxt.module.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据Id查询用户
    public List<User> findUserById(@Param("id") int id);

}
