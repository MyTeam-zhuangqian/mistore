package com.example.mistroe.web;

import com.example.mistroe.function.UserFunction;
import com.example.mistroe.pojo.Good;
import com.example.mistroe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zlin
 * @date 2020/3/23 13:46
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

    @RequestMapping("/index")
    String index() {
        return "index";
    }

    @RequestMapping("/good")
    String Goods() {
        return "good";
    }

    @RequestMapping("/sell")
    String sell() {
        return "sell";
    }

    @RequestMapping("/Cart")
    String Cart(){ return "Cart"; }

    @RequestMapping("/Goodsinfo")
    String GoodsInfo(){ return "Goodsinfo"; }

    @RequestMapping("/login_go")
    @ResponseBody
    User loginGo(@RequestParam("name") String name, @RequestParam("pwd") String pwd, HttpServletRequest request) {

        //执行登陆方法
        try {
            //登陆成功
            User user = userFunction.loginGO(name, pwd);
            request.getSession().setAttribute("user",user);
            return user;
        }catch (Exception e){
            //登陆失败
            return null;
        }
    }

    @RequestMapping("/index_center")
    ModelAndView indexCenter(){
        return null;
    }


}
