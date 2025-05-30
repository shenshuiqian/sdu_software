package cn.liantao.lbook.mapper;

import cn.liantao.lbook.entity.SalesInvoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleMapper {
    List<SalesInvoice> getAllSalesInvoice();
    List<SalesInvoice> getSalesInvoiceFromAccount(String account);
}
