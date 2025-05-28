package cn.liantao.lbook.service;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    @Autowired
    private BookMapper bookMapper;
    // 获取所有书籍


    // 查找书籍
    @Override
    public Book getBook(String ISBN){
        Book book = bookMapper.getBook(ISBN);
        System.out.println(book.getISBN());
        return book;
    }


}
