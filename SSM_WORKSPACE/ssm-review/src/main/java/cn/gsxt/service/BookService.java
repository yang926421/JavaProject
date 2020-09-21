package cn.gsxt.service;

import cn.gsxt.module.Books;

import java.util.List;

public interface BookService {

    //增加一本书
    public int addBook(Books books);

    //查询所有书
    public List<Books> findAllBooks();

    //删除一本书
    public void deleteBooksById(int id);

    //修改一本书
    public void updateBook(Books books);

    //查询一本书
    public Books findBookById(int id);
}
