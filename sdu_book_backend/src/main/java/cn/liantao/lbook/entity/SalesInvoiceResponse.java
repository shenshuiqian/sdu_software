package cn.liantao.lbook.entity;

import cn.liantao.lbook.entity.SalesInvoice;
import java.util.List;

public class SalesInvoiceResponse {
    private List<List<Object>> orders;

    public SalesInvoiceResponse(List<List<Object>> orders) {
        this.orders = orders;
    }

    public List<List<Object>> getOrders() {
        return orders;
    }

    public void setOrders(List<List<Object>> orders) {
        this.orders = orders;
    }
}

