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
    @ResponseBody
    public LoginState login(String account,String password){
        LoginState loginState=new LoginState();
        User tempUser=userService.getUser(account);
        if(tempUser!=null){
            if(password.equals(tempUser.getPassword())){
                loginState.setAccount(tempUser.getAccount());
                loginState.setName(tempUser.getUsername());
                loginState.setIsLogin(true);
                loginState.setMessage("操作成功");
                if(tempUser.getIsManager()){
                    loginState.setCode(1);
                }
                else loginState.setCode(0);
                return loginState;
            }
            loginState.setIsLogin(false);
            loginState.setMessage("密码错误");
            return loginState;
        }
        loginState.setMessage("未找到用户");
        loginState.setIsLogin(false);
        return loginState;
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
