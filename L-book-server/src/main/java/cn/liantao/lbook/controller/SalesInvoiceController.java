package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.entity.SalesInvoice;
import cn.liantao.lbook.entity.SalesInvoiceResponse;
import cn.liantao.lbook.service.BookService;
import cn.liantao.lbook.service.SalesInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SalesInvoiceController {
    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @Autowired
    private BookService bookService;
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
}
