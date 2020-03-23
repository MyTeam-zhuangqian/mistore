package com.example.mistroe.web;

import com.example.mistroe.function.UserFunction;
import com.example.mistroe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zlin
 * @date 2020/3/23 13:46
 */
@Controller
public class LoginController {
    @Autowired
    UserFunction userFunction;

    @RequestMapping("/login")
    String login(){
        return "login";
    }
    @RequestMapping("/index")
    String index(){
        return "index";
    }

    @RequestMapping("/login_go")
    @ResponseBody
    User loginGo(String name,String pwd){
        User user = null;
        user = userFunction.loginGO(name,pwd);
        if (user!=null){
            return user;
        }
        return null;
    }
}
