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


    /**
    * @Description: 用户注册
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/insert")
    @ResponseBody
    @Transactional
    public Result insert(User user){
        System.out.println(user);
        Result result = new Result();
        int i = userFunction.insert(user);//实现用户注册
        //下面代码为前端接口所需数据格式
        if (i == 1){
            result.setStatus(0);
        }else {
            result.setStatus(-1);
            result.setMessage("网络繁忙");
        }
        return result;
    }

    /**
    * @Description: 用户注册时上传头像
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/updateHeadPortrait")
    @ResponseBody
    @Transactional
    public Result updateHeadPortrait(String img, HttpServletRequest request){
        img = "img/"+img;
        Result result = new Result();
        User user = (User)request.getSession().getAttribute("user");
        if (user !=null){
            user.setHeadPortrait(img);//用户注册上传头像，数据库保存其头像地址
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

    /**
    * @Description: 用户更新个人信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/update")
    @ResponseBody
    @Transactional
    public Result update(User user,HttpServletRequest request){
        Result result = new Result();
        System.out.println(user+"\n===============================================================================================");
        int i = userFunction.update(user);
        if (i == 1){
            result.setStatus(0);
            User user1 = userFunction.selectUserById(user.getIdUser());//用户更新个人信息 具体实现
            request.getSession().setAttribute("user",user1);
        }else {
            result.setStatus(-1);
            result.setMessage("网络异常");
        }
        return  result;
    }
}
