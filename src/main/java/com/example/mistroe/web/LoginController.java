package com.example.mistroe.web;

import com.example.mistroe.function.CartFunction;
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
    @Autowired
    CartFunction cartFunction;

    /**
    * @Description: 请求跳转登陆页面
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/login")
    String login() {
        return "login";
    }


    /**
    * @Description: 请求跳转注册页面
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/register")
    String register(){
        return "register";
    }


    /**
    * @Description: 请求跳转首页
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/index")
    String index() {
        return "index";
    }

    
    /** 
    * @Description: 访问发布商品页面 
    * @Param:  
    * @return:  
    * @Author: 刘丹
    * @Date: 2020/4/26 
    */ 
    @RequestMapping("/sell")
    String sell(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            return "sell";
        }else {
            return "login";
        }

    }

    /** 
    * @Description: 访问购物车页面，实现查询购物车商品信息 
    * @Param:  
    * @return:  
    * @Author: 刘丹
    * @Date: 2020/4/26 
    */ 
    @RequestMapping("/Cart")
    String Cart(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            List<Good> goodList=goodFunction.getCartGood(user.getName());//实现购物车商品数据查询方法getCartGood
            request.setAttribute("goods",goodList);
            return "Cart";
        }else {
            return "login";
        }
    }
    
    /** 
    * @Description: 实现登录功能，登录成功或失败跳转到相对应页面 
    * @Param:  
    * @return:  
    * @Author: 刘丹
    * @Date: 2020/4/26 
    */ 
    @RequestMapping("/login_go")
    @ResponseBody
    User loginGo(String name, String pwd, HttpServletRequest request){
        System.out.println(name+" "+pwd);
        User user = null;
        request.getSession().setAttribute("money",100.00);
        User userx = (User)request.getSession().getAttribute("user");//获取session缓存user
        if (userx!=null&&user==null){
            if(name.equals(userx.getName())){
                request.getSession().setAttribute("user", userx);
                int cartCount = cartFunction.selectCountByUser(userx.getName());//加载购物车商品数量用selectCountByUser实现
                request.getSession().setAttribute("cartCount", cartCount);
                return userx;
            }else{
                user = userFunction.loginGO(name, pwd);//查询当前登录用户是否存在，loginGO方法实现,同下
                request.getSession().setAttribute("user",user);
                int cartCount = cartFunction.selectCountByUser(user.getName());
                request.getSession().setAttribute("cartCount",cartCount);
                return user;
            }
        }
        //执行登陆方法
        else{
            //登陆成功
            user = userFunction.loginGO(name, pwd);
            request.getSession().setAttribute("user",user);
            int cartCount = cartFunction.selectCountByUser(user.getName());
            request.getSession().setAttribute("cartCount",cartCount);
            return user;
        }
    }

    
    /** 
    * @Description: 请求跳转个人中心页面 
    * @Param:  
    * @return:  
    * @Author: 刘丹
    * @Date: 2020/4/26 
    */ 
    @RequestMapping("/profile")
    String profile(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            return "profile";
        }else {
            return "login";
        }
    }


    /**
    * @Description: 请求跳转订单管理页面，并预加载我卖出的所有商品信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/order")
    String order(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            List<Good> goodList=goodFunction.Mysell(user.getIdUser());//实现查询我卖出的所有商品信息，Mysell方法实习
            request.setAttribute("goods",goodList);
            return "order";
        }else {
            return "login";
        }
    }

    
    /** 
    * @Description: 请求访问物流管理页面，并预加载我买到的未发货的所有商品信息
    * @Param:  
    * @return:  
    * @Author: 刘丹
    * @Date: 2020/4/26 
    */ 
    @RequestMapping("/post")
    String post(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            List<Good> goodList=goodFunction.GetBuy(user.getIdUser());//查询所有我买到的未发货商品信息，用GetBuy方法实现
            request.setAttribute("goods",goodList);
            return "post";
        }else {
            return "login";
        }
    }


}
