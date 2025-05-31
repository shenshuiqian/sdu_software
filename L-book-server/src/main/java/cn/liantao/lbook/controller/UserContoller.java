package cn.liantao.lbook.controller;

import cn.liantao.lbook.entity.Book;
import cn.liantao.lbook.entity.User;
import cn.liantao.lbook.entity.LoginState;
import cn.liantao.lbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

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
                if(tempUser.getIsManager()){
                    loginState.setCode(1);
                }
                else loginState.setCode(0);
                if(tempUser.getAllowed()){
                    loginState.setIsLogin(true);
                    loginState.setMessage("操作成功");
                    return loginState;
                }else{
                    loginState.setIsLogin(false);
                    loginState.setMessage("您已被封号，请等待解封...");
                    return loginState;
                }

            }
            loginState.setIsLogin(false);
            loginState.setMessage("密码错误");
            return loginState;
        }
        loginState.setMessage("未找到用户");
        loginState.setIsLogin(false);
        return loginState;
    }
    @GetMapping(value = "/signup")
    @CrossOrigin
    @ResponseBody
    public String signup(String account,String name,String password,String mail){
        User temp=userService.getUser(account);
        String response="";
        if(temp!=null){
            response="手机号已被注册";
        }
        else{
            userService.addUser(account, password, name, false, mail, 0.0F,true);
            response="注册成功";
        }
        return response;
    }
    @GetMapping(value = "/logout")
    @CrossOrigin
    @ResponseBody
    public String logout(){
        return "退出成功";
    }
    @GetMapping(value = "/mail")
    @CrossOrigin
    @ResponseBody
    public String sendmail(String phoneNumber){
        User user=userService.getUser(phoneNumber);
        if(user!=null){
            return user.getPassword();
        }
        return "用户不存在";
    }
    @GetMapping(value = "/userstates")
    @CrossOrigin
    @ResponseBody
    public List<User> getuserstate(){
        return userService.getAllUser();
    }
    @GetMapping(value = "/userchange")
    @CrossOrigin
    @ResponseBody
    public String userchange(String account){
        userService.changeState(account);
        return account;
    }
}
