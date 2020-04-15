package com.example.mistroe.web;

import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.pojo.Good;
import com.example.mistroe.pojo.GoodType;
import com.example.mistroe.pojo.User;
import com.example.mistroe.util.Result;
import com.example.mistroe.util.UpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.List;


/**
 * @author zlin
 * @date 2020/3/31 11:44
 */
@Controller
@RequestMapping("/good")
public class GoodController {
    @Autowired
    GoodFunction goodFunction;


    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file, HttpServletRequest request) {
        //System.out.println("图片上传================================================");
        Result result = new Result();
        try {
            UpUtils.upfile(file, request);
            result.setStatus(0);
            result.setMessage(file.getOriginalFilename());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(500);
            result.setMessage("上传异常");
            return result;
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    @Transactional //开启事务（开启事务的方法必须是public）
    public Result insert(Good good ,HttpServletRequest request) {
        User user= (User)request.getSession().getAttribute("user");
        int i = goodFunction.insert(good,user.getIdUser());
        Result result = new Result();
        if (i == 1){
            result.setStatus(0);
        }else {
            result.setStatus(500);
            result.setMessage("网络繁忙！");
        }
        return result;
    }

    @RequestMapping("/selectAllType")
    @ResponseBody
    Result selectAllType() {
        List<GoodType> goodTypes = null;
        goodTypes = goodFunction.selectAllType();
        Result result = new Result();
        if (goodTypes != null){
            result.setStatus(0);
            result.setData(goodTypes);
        }else {
            result.setStatus(500);
            result.setMessage("网络繁忙！");
        }
        return result;
    }
    @RequestMapping("/CE")
    @ResponseBody
    List<Good> CE(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/PC")
    @ResponseBody
    List<Good> PC(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/KZ")
    @ResponseBody
    List<Good> KZ(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/KG")
    @ResponseBody
    List<Good> KG(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/KY")
    @ResponseBody
    List<Good> KY(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/WX")
    @ResponseBody
    List<Good> WX(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/ZW")
    @ResponseBody
    List<Good> ZW(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/SX")
    @ResponseBody
    List<Good> SX(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }
    @RequestMapping("/MU")
    @ResponseBody
    List<Good> MU(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    @RequestMapping("/search")
    @ResponseBody
    Result search(String key ,HttpServletRequest request) {
        List<Good> goods = null;
        goods = goodFunction.getGoodByKey(key);
        Result result = new Result();
        if(goods != null){
            request.getSession().setAttribute("goods",goods);
            result.setStatus(0);
        }else {
            result.setStatus(-1);
            result.setMessage("网络异常");
        }


        return result;
    }
}
