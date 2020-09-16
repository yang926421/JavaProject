package cn.gsxt.mapper;

import cn.gsxt.module.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from account")
    List<User> getUsers();

    //注解完成crud

    //    增加
    @Insert("insert into account values(#{id},#{name},#{money})")
    public void insert(User user);

    //通过id查询  /有多个参数的时候加上param   一个参数的时候可以不写也可写上
    @Select("select * from account where id = #{id}")
    User  getUserById(@Param("id") int id);

    //修改
    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    public void update(User user);

    //删除
    @Delete("delete from  account where id = #{uid} ")
    public void delete(@Param("uid")int id);

}
