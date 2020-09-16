package cn.gsxt.mapper;


import cn.gsxt.module.Blog;
import cn.gsxt.utils.IDutils;
import cn.gsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogTest {

    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void getBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put("title", "Java");
        List<Blog> blogByTitle = mapper.findBlogByTitle(stringStringHashMap);
        for (Blog blog : blogByTitle) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

}
