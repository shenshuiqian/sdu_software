package cn.liantao.lbook.service;

import cn.liantao.lbook.entity.SalesInvoice;

import java.sql.Timestamp;
import java.util.List;

public interface SalesInvoiceService {
    List<SalesInvoice> getAllSalesInvoice();
    List<SalesInvoice> getSalesInvoiceFromAccount(String account);
    List<SalesInvoice> getSalesInvoiceBetweenTime(Timestamp time1,Timestamp time2);
}
