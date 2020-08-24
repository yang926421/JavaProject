package cn.gsxt.mapper;

import cn.gsxt.domain.Role;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("select * from sys_user_role ur, sys_role r where ur.roleid = r.id and ur.userid =#{uid} ")
    public List<Role> findByUid(int uid);

}
