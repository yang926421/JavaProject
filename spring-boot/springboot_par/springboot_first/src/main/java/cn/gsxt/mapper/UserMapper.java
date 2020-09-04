package cn.gsxt.mapper;

import cn.gsxt.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

//@Mapper //可以在启动类加全局扫描
@Component
//单表的增删改查
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User SelectById(int id);

    @Select("select * from user")
    public List<User> selectAll();

    @Insert("insert into user(id, username, password, birthday) values(#{id}, #{username}," +
            "#{password}, #{birthday})")
    public void insert(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(int id);

    @Delete("update user set username=#{username},password=#{password} where id = #{id}")
    public void update(User user);
}
