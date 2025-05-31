package cn.liantao.lbook.service;

import cn.liantao.lbook.entity.SalesInvoice;
import cn.liantao.lbook.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SalesInvoiceServiceImpl implements SalesInvoiceService{
    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<SalesInvoice> getSalesInvoiceFromAccount(String account){
        List<SalesInvoice> salesInvoice = saleMapper.getSalesInvoiceFromAccount(account);
        //System.out.println(book.getISBN());
        return salesInvoice;
    }

    @Override
    public List<SalesInvoice> getAllSalesInvoice(){
        return saleMapper.getAllSalesInvoice();
    }

    @Override
    public List<SalesInvoice> getSalesInvoiceBetweenTime(Timestamp time1, Timestamp time2){
        return saleMapper.getSalesInvoiceBetweenTime(time1,time2);
    }

    @Override
    public void insertSalesInvoice(SalesInvoice invoice){
        saleMapper.insertSalesInvoice(invoice);
    }
}
