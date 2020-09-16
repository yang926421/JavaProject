package cn.gsxt.mapper;

import cn.gsxt.module.Teacher;
import cn.gsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TeacherTest {

    //在日志中进行自定义 加输出语句
    Logger logger = Logger.getLogger(TeacherTest.class);

    @Test
    public void test1(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherById = mapper.findTeacherById(1);
        System.out.println(teacherById);
        sqlSession.close();

    }



    //配置好log4j进行测试
    @Test
    public void testLog4j(){
        logger.info("info:进入到了log4j自定义日志");
        logger.debug("debug:进入到了log4j自定义日志");
        logger.error("error:进入到了log4j自定义日志");
    }
}
