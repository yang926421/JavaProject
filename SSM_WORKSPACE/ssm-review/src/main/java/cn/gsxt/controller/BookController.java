package cn.gsxt.controller;


import cn.gsxt.module.Books;
import cn.gsxt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    //查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> allBooks = bookService.findAllBooks();
        model.addAttribute("list",allBooks);
        System.out.println(allBooks);
        return "allBook";
    }

    //增加书籍按钮

    @RequestMapping("/addBook")
    public String addBook(Model model){
        Books books = new Books();
        books.setBookID(4);
        books.setBookCounts(10);
        books.setBookName("python");
        books.setDetail("人生苦短,我学Python");
        bookService.addBook(books);
        return "addBook";
    }
}
