package cn.liantao.lbook.entity;

import lombok.Data;

@Data
public class PurchaseInvoice {
    private String id;
    private String ISBN;
    private String name;
    private String count;
    private String price;
}
