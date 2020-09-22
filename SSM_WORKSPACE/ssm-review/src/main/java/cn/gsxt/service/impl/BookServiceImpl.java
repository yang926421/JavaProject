package cn.gsxt.service.impl;

import cn.gsxt.mapper.BookMapper;
import cn.gsxt.module.Books;
import cn.gsxt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public List<Books> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    public void deleteBooksById(int id) {
         bookMapper.deleteBooksById(id);
    }

    public void updateBook(Books books) {
        bookMapper.updateBook(books);
    }

    public Books findBookById(int id) {
        return bookMapper.findBookById(id);
    }
}
