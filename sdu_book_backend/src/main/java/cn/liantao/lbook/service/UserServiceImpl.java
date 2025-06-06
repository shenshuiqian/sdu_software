package cn.liantao.lbook.service;


import cn.liantao.lbook.entity.User;
import cn.liantao.lbook.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public User getUser(String account){
        return userMapper.getUser(account);
    }
    public void addUser(String account,String password,String username,Boolean isManager,String mail,Float money,Boolean allowed){
        userMapper.addUser(account,password,username,isManager,mail,money,allowed);
    }

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
    public void changeState(String account){
        userMapper.changeState(account);
    }
}
