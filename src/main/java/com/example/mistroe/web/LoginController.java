package com.example.mistroe.web;

import com.example.mistroe.function.UserFunction;
import com.example.mistroe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zlin
 * @date 2020/3/23 13:46
 */
/*
@CrossOrigin 跨域请求注解
*/
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserFunction userFunction;

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/register")
    String register(){
        return "register";
    }

    @RequestMapping("/index")
    String index() {
        return "index";
    }

    @RequestMapping("/good")
    String Goods() {
        return "good";
    }

    @RequestMapping("/sell")
    String sell(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            return "sell";
        }else {
            return "login";
        }

    }

    @RequestMapping("/Cart")
    String Cart(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            return "sell";
        }else {
            return "Cart";
        }
    }

    @RequestMapping("/Goodsinfo")
    String GoodsInfo(){ return "Goodsinfo"; }

    @RequestMapping("/login_go")
    @ResponseBody
    User loginGo(String name, String pwd, HttpServletRequest request) {
        User user = null;
        //执行登陆方法
        try {
            //登陆成功
            user = userFunction.loginGO(name, pwd);
            request.getSession().setAttribute("user",user);
            System.out.println("用户id"+user.getIdUser());
            return user;
        }catch (Exception e){
            //登陆失败
            return user;
        }
    }

    @RequestMapping("/profile")
    String profile(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            return "profile";
        }else {
            return "login";
        }
    }

    @RequestMapping("/order")
    String order(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            return "order";
        }else {
            return "login";
        }
    }

    @RequestMapping("/post")
    String post(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            return "post";
        }else {
            return "login";
        }
    }


}
