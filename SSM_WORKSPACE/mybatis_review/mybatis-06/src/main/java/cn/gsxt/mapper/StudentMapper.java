package cn.gsxt.mapper;

import cn.gsxt.module.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生信息
    public List<Student> findAllStudent();

    //查询所有的学生信息
    public List<Student> findAllStudent2();
}
