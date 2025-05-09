package cn.liantao.lbook.entity;

import lombok.Data;

//Book实体定义
@Data
public class Book {
    private String name;//书的名称
    private String author;//作者
    private String ISBN;//ISBN号
    private Integer stock;
    private Float price;
    private String version;
    private Integer pages;
}
