package cn.liantao.lbook.mapper;

import cn.liantao.lbook.entity.SalesInvoice;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SaleMapper {
    List<SalesInvoice> getAllSalesInvoice();
    List<SalesInvoice> getSalesInvoiceFromAccount(String account);
    List<SalesInvoice> getSalesInvoiceBetweenTime(Timestamp time1,Timestamp time2);
    List<SalesInvoice> getSalesInvoiceBetweenTimeFromAccount(Timestamp time1,Timestamp time2,String account);
    void insertSalesInvoice(SalesInvoice invoice);
}
