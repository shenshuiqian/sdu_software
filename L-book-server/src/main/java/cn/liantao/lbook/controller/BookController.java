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
    @GetMapping(value = "/addbook")
    @CrossOrigin
    @ResponseBody
    public void addBook(String name,String author,String isbn,String outline,
                        float price,int stock,String cover,
                        String press,String year,int pages){
        Book book=new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setOutline(outline);
        book.setPrice(price);
        book.setStock(stock);
        book.setYear(year);
        book.setPages(pages);
        bookService.addBook(book);
    }

    @GetMapping(value = "/detail")
    @CrossOrigin
    @ResponseBody
    public Book getDetailWithIsbn(String ISBN){
        return bookService.getBook(ISBN);
    }
    @GetMapping(value = "/modify")
    @CrossOrigin
    @ResponseBody
    public void bookModify(String name,String author,String isbn,String newisbn,
                           String outline,float price,int stock,String cover,String press,String year,int pages){
        bookService.deleteBook(isbn);
        addBook(name,author,newisbn,outline, price,stock,cover,
                press,year,pages);
    }
    @GetMapping(value = "/delete")
    @CrossOrigin
    @ResponseBody
    public String bookdelete(String ISBN){
        bookService.deleteBook(ISBN);
        String response="删除成功";
        return response;
    }
}
