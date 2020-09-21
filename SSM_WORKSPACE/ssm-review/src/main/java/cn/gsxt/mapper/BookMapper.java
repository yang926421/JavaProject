package cn.gsxt.mapper;

import cn.gsxt.module.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.*;
import java.awt.print.Book;
import java.util.List;

public interface BookMapper {

    //增加一本书
    public int addBook(Books books);

    //查询所有书
    public List<Books> findAllBooks();

    //删除一本书
    public void deleteBooksById(@Param("bookId") int id);

    //修改一本书
    public void updateBook(Books books);

    //查询一本书
    public Books findBookById(@Param("bookId") int id);

}
