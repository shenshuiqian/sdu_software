package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.entity.User;
import cn.liantao.lbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api")
public class UserContoller {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/login")
    public Map<String, Object> login(String account,String password){
        User tempUser=userService.getUser(account);
        Map<String, Object> response = new HashMap<>();
        Map<String,Boolean> t= new HashMap<>();;
        if(password.equals(tempUser.getPassword())){
            response.put("code", 200);
            t.put("isLogin",true);
            if(tempUser.getIsManager()){
                t.put("code",true);
            }
            else t.put("code",false);
           // response.put("isLogin", 200);
            response.put("message", "操作成功");
            response.put("data", t);
            return response;
        }
        response.put("code", 200);
        response.put("message", "操作失败");
        response.put("data", tempUser);
        return response;

    }
}
