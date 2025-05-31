package cn.liantao.lbook.service;

import cn.liantao.lbook.entity.SalesInvoice;

import java.util.List;

public interface SalesInvoiceService {
    List<SalesInvoice> getAllSalesInvoice();
    List<SalesInvoice> getSalesInvoiceFromAccount(String account);
}
