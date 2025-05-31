package cn.liantao.lbook.mapper;

import cn.liantao.lbook.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper
public interface BookMapper {
    Book getBook(String isbn);
    List<Book> getBooks();
    List<Book> searchBooks(String filter);
    void deleteBook(String isbn);
    void addBook(Book book);
}