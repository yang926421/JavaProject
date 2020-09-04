package cn.gsxt.mapper;

import cn.gsxt.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapperTest {

    public User SelectById(int id);
    public List<User> selectAll();
    public void insert(User user);
    public void delete(int id);
    public void update(User user);


}
