package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.*;
import cn.liantao.lbook.service.BookService;
import cn.liantao.lbook.service.SalesInvoiceService;
import cn.liantao.lbook.service.UserService;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SalesInvoiceController {
    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;
    @GetMapping(value = "/order/getall")
    @CrossOrigin
    @ResponseBody
    public SalesInvoiceResponse getAllSalesInvoice() {
        //List<SalesInvoice> salesInvoices=salesInvoiceService.getAllSalesInvoice();
        //return salesInvoices;
        //return new SalesInvoiceResponse(salesInvoices);
        List<SalesInvoice> salesInvoices = salesInvoiceService.getAllSalesInvoice();
        List<List<Object>> wrapped = new ArrayList<>();

        for (SalesInvoice invoice : salesInvoices) {
            List<Object> inner = new ArrayList<>();
            inner.add(invoice);
            wrapped.add(inner);
        }

        return new SalesInvoiceResponse(wrapped);
    }
    @GetMapping(value = "/order/search")
    @CrossOrigin
    @ResponseBody
    public SalesInvoiceResponse getSalesInvoiceFromAccount(String filter) {
        //List<SalesInvoice> salesInvoices=salesInvoiceService.getSalesInvoiceFromAccount(account);
        //return salesInvoices;
        List<SalesInvoice> salesInvoices = salesInvoiceService.getSalesInvoiceFromAccount(filter);
        List<List<Object>> wrapped = new ArrayList<>();

        for (SalesInvoice invoice : salesInvoices) {
            List<Object> inner = new ArrayList<>();
            inner.add(invoice);
            wrapped.add(inner);
        }

        return new SalesInvoiceResponse(wrapped);
    }

    @GetMapping(value = "/order/date")
    @CrossOrigin
    @ResponseBody
    public List<SalesInvoice> getSalesInvoiceBetweenTime(
            @RequestParam("beginDate") String time1Str,
            @RequestParam("endDate") String time2Str,
            @RequestParam("account") String account
    ) {
        time1Str += " 00:00:00";
        time2Str += " 23:59:59";
        Timestamp ts1 = Timestamp.valueOf(time1Str);
        Timestamp ts2 = Timestamp.valueOf(time2Str);

        List<SalesInvoice> salesInvoices = salesInvoiceService.getSalesInvoiceBetweenTime(ts1,ts2);

        return salesInvoices;
    }

    @GetMapping(value = "/order/dateDetail")
    @CrossOrigin
    @ResponseBody
    public List<SalesInvoice> getSalesInvoiceBetweenTimeDetail(
            @RequestParam("beginDate") String time1Str,
            @RequestParam("endDate") String time2Str,
            @RequestParam("account") String account
    ) {
        time1Str += " 00:00:00";
        time2Str += " 23:59:59";
        Timestamp ts1 = Timestamp.valueOf(time1Str);
        Timestamp ts2 = Timestamp.valueOf(time2Str);

        List<SalesInvoice> salesInvoices = salesInvoiceService.getSalesInvoiceBetweenTime(ts1,ts2);

        return salesInvoices;
    }

    @GetMapping(value = "/order/add")
    @CrossOrigin
    @ResponseBody
    public void addSalesInvoice(@RequestBody List<OrderRequest> orders) {
        for(OrderRequest order : orders){
            SalesInvoice invoice = new SalesInvoice();
            invoice.setAccount(order.getAccount());
            invoice.setISBN(order.getIsbn());
            invoice.setCount(order.getCount());
            invoice.setDate(new Timestamp(System.currentTimeMillis()));
            Book book = bookService.getBook(order.getIsbn());
            User user = userService.getUser(order.getAccount());
            invoice.setUser_name(user.getUsername());
            invoice.setBook_name(book.getName());
            invoice.setAuthor(book.getAuthor());
            invoice.setPrice(book.getPrice());
            invoice.setIs_purchase(true);
            book.setStock(book.getStock()-order.getCount());
            salesInvoiceService.insertSalesInvoice(invoice);
            bookService.deleteBook(order.getIsbn());
            bookService.addBook(book);
        }
    }

}
