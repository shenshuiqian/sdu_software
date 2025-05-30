package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.service.BookService;
import cn.liantao.lbook.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class BookController {

    // 创建连接数据库的接口实例
    @Autowired
    private BookService bookService;
    @GetMapping(value = "/getBook")
    @CrossOrigin
    @ResponseBody
    public Book getBook() {
        return bookService.getBook("1234567890");
    }
    @GetMapping(value = "/getBooks")
    @CrossOrigin
    @ResponseBody
    public List<Book> getBooks() {
        List<Book> books=bookService.getBooks();
        return books;
    }


}
