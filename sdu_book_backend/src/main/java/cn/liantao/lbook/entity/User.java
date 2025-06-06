package cn.liantao.lbook.entity;

import lombok.Data;

//User实体定义
@Data
public class User {
    private String account;
    private String password;
    private String username;
    private Boolean isManager;
    private String mail;
    private Float money;
    private Boolean allowed;
}