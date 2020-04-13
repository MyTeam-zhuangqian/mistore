package com.example.mistroe.web;

import com.example.mistroe.function.UserFunction;
import com.example.mistroe.pojo.User;
import com.example.mistroe.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zlin
 * @date 2020/4/11 11:30
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserFunction userFunction;

    @RequestMapping("/insert")
    @ResponseBody
    @Transactional
    public Result insert(User user){
        System.out.println(user);
        Result result = new Result();
        int i = userFunction.insert(user);
        if (i == 1){
            result.setStatus(0);
        }else {
            result.setStatus(-1);
            result.setMessage("网络繁忙");
        }
        return result;
    }
    @RequestMapping("/updateHeadPortrait")
    @ResponseBody
    @Transactional
    public Result updateHeadPortrait(String img, HttpServletRequest request){
        img = "img/"+img;
        Result result = new Result();
        User user = (User)request.getSession().getAttribute("user");
        if (user !=null){
            user.setHeadPortrait(img);
            int i = userFunction.updateHeadPortrait(user);
            if (i == 1){
                result.setStatus(0);
                request.getSession().setAttribute("user",user);
            }else {
                result.setStatus(-1);
                result.setMessage("网络繁忙");
            }
        }

        return result;
    }
}
