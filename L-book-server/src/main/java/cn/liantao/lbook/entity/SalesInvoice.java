package cn.liantao.lbook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

// Order实体定义
@Data
public class SalesInvoice {
    private Integer id;
    private String account;
    private String userName;
    private String bookName;
    private String author;
    private String ISBN;
    private Float price;
    private Integer count;
    private Boolean isPurchase;//是否已经付款
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp date;
}
