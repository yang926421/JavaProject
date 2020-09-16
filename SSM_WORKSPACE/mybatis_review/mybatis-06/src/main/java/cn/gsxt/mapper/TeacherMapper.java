package cn.gsxt.mapper;

import cn.gsxt.module.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select * from teacher")
    public Teacher findAll();

//    @Select("select * from teacher where id = #{tid}")
    public Teacher findTeacherById(@Param("tid") int tid);
}
