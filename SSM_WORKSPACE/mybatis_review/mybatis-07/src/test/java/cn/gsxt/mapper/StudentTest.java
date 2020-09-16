package cn.gsxt.mapper;

import cn.gsxt.module.Student;
import cn.gsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.findAllStudent2();
        for (Student student : allStudent) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
