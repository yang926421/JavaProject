package cn.gsxt.mapper;

import cn.gsxt.module.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
//    public
    int addBlog(Blog blog);

    List<Blog> findBlogByTitle(Map map);

}
