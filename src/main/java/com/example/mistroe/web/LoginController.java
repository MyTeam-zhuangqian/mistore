package com.example.mistroe.web;

import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.function.UserFunction;
import com.example.mistroe.pojo.Good;
import com.example.mistroe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    GoodFunction goodFunction;
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
            List<Good> goodList=goodFunction.getCartGood(user.getName());
            request.setAttribute("goods",goodList);
            return "Cart";
        }else {
            return "login";
        }
    }

    @RequestMapping("/Goodsinfo")
    String GoodsInfo(){ return "Goodsinfo"; }

    @RequestMapping("/login_go")
    @ResponseBody
    User loginGo(String name, String pwd, HttpServletRequest request){
        System.out.println(name+" "+pwd);
        User user = null;
        request.getSession().setAttribute("money",100.00);
        user = (User)request.getSession().getAttribute("user");
        if (user!=null){
            request.getSession().setAttribute("user",user);
            return user;
        }
        //执行登陆方法
        else{
            //登陆成功
            user = userFunction.loginGO(name, pwd);
            request.getSession().setAttribute("user",user);
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
            List<Good> goodList=goodFunction.GetBuy(user.getIdUser());
            request.setAttribute("goods",goodList);
            return "post";
        }else {
            return "login";
        }
    }


}
