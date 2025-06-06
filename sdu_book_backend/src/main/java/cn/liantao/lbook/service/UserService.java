package cn.liantao.lbook.service;


import cn.liantao.lbook.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String account);
    List<User> getAllUser();
    void changeState(String account);
    void addUser(String account,String password,String username,Boolean isManager,String mail,Float money,Boolean allowed);
}
