package cn.liantao.lbook.service;


import cn.liantao.lbook.entity.User;

public interface UserService {
    User getUser(String account);
    void addUser(String account,String password,String username,Boolean isManager,String mail,Float money);
}
