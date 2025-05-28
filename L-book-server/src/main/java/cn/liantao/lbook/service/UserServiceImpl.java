package cn.liantao.lbook.service;


import cn.liantao.lbook.entity.User;
import cn.liantao.lbook.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public User getUser(String account){
        return userMapper.getUser(account);
    }
}
