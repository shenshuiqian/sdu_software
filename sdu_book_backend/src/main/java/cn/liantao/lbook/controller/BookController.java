package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.service.BookService;
import cn.liantao.lbook.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.IOException;
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
        book.setCover(cover);
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
    @GetMapping(value = "/searchbooks")
    @CrossOrigin
    @ResponseBody
    public List<Book> searchbooks(String filter){
        filter="%"+filter+"%";
        return bookService.searchBooks(filter);
    }

    public String processPath(String path){
        String t="";
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='\\'){
                t=t+"/";
            }
            else{
                t=t+path.charAt(i);
            }
        }
        t=t+"/";
        return t;
    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        // 获取图片文件名
        System.out.print(123);
        String fileName = file.getOriginalFilename();

        // 文件大小控制（单位：字节）
        if (file.getSize() > 500 * 1024) {
            return "文件过大";
        }

        // 设置保存路径
        String uploadDir = processPath(System.getProperty("user.dir"));

        uploadDir+="src/main/java/cn/liantao/lbook/images/";
        //uploadDir="E:/work/大三下/软件工程/sud/sdu_software/sdu_book_backend/src/main/java/cn/liantao/lbook/images";
        // 创建文件夹（如果不存在）
        System.out.println(uploadDir);
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 组合完整路径
        File dest = new File(uploadDir + fileName);
        System.out.println(dest);
        try {
            // 保存文件到目标路径
            file.transferTo(dest);
            return fileName;
            //return "上传成功，文件路径为：" + dest.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "文件保存失败：" + e.getMessage();
        }
    }

}
