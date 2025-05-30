package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.entity.SalesInvoice;
import cn.liantao.lbook.service.BookService;
import cn.liantao.lbook.service.SalesInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SalesInvoiceController {
    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @GetMapping(value = "/getAllSales")
    @CrossOrigin
    @ResponseBody
    public List<SalesInvoice> etAllSalesInvoice() {
        List<SalesInvoice> salesInvoices=salesInvoiceService.getAllSalesInvoice();
        return salesInvoices;
    }
    @GetMapping(value = "/getSalesFromAccount")
    @CrossOrigin
    @ResponseBody
    public List<SalesInvoice> getSalesInvoiceFromAccount(String account) {
        List<SalesInvoice> salesInvoices=salesInvoiceService.getSalesInvoiceFromAccount(account);
        return salesInvoices;
    }
}
