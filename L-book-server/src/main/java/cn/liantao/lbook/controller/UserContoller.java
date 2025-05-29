package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.entity.User;
import cn.liantao.lbook.entity.LoginState;
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
    @CrossOrigin
    public Map<String, Object> login(String account,String password){
        Map<String, Object> response = new HashMap<>();
        LoginState loginState=new LoginState();
        User tempUser=userService.getUser(account);
        if(tempUser!=null){
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
                response.put("data", tempUser);
                return response;
            }

        }
        response.put("code", 200);
        response.put("message", "操作失败");
        //response.put("data", t);
        return response;
    }
    @GetMapping(value = "/register")
    public Map<String,Object> register(String account,String password,String username,Boolean isManager,String mail){
        userService.addUser(account, password, username, isManager, mail, 0.0F);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        Map<String,Boolean> t= new HashMap<>();;
        response.put("message", "成功");
        response.put("data", t);
        return response;
    }
}
