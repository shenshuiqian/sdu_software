package cn.liantao.lbook.service;

import cn.liantao.lbook.entity.SalesInvoice;

import java.util.List;

public interface OrderService {

    // 添加订单
    void addOrder(List<SalesInvoice> order);

    // 获取所有订单
    List<SalesInvoice> getAllOrders();

    // 获取指定用户订单
    List<SalesInvoice> getOrder(String account);

    // 搜索订单
    List<SalesInvoice> searchOrder(String filter);

    // 筛选指定日期内指定用户的订单
    List<DateOrder> dateFilter(String beginDate, String endDate, String account);

    // 筛选指定日期内指定用户的详细订单
    List<DateOrder> dateDetailFilter(String beginDate, String endDate, String account);
}
