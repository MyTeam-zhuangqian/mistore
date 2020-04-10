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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

        List<Good> goods=(List<Good>)request.getAttribute("goods");
        if(goods==null){
            List<Good> goodList=goodFunction.getGoodByType(ty);
            request.setAttribute("goods",goodList);
            return goodList;
        }else {
            return goods;
        }
    }
    @RequestMapping("/PC")
    @ResponseBody
    List<Good> PC(String ty,HttpServletRequest request){

        List<Good> goods=(List<Good>)request.getAttribute("good02");
        if(goods==null){
            List<Good> goodList=goodFunction.getGoodByType(ty);
            request.setAttribute("good02",goodList);
            return goodList;
        }else {
            return goods;
        }
    }
    @RequestMapping("/KZ")
    @ResponseBody
    List<Good> KZ(String ty,HttpServletRequest request){

        List<Good> goods=(List<Good>)request.getAttribute("good03");
        if(goods==null){
            List<Good> goodList=goodFunction.getGoodByType(ty);
            request.setAttribute("good03",goodList);
            return goodList;
        }else {
            return goods;
        }
    }
    @RequestMapping("/KG")
    @ResponseBody
    List<Good> KG(String ty,HttpServletRequest request){

        List<Good> goods=(List<Good>)request.getAttribute("good04");
        if(goods==null){
            List<Good> goodList=goodFunction.getGoodByType(ty);
            request.setAttribute("good04",goodList);
            return goodList;
        }else {
            return goods;
        }
    }
    @RequestMapping("/KY")
    @ResponseBody
    List<Good> KY(String ty,HttpServletRequest request){

        List<Good> goods=(List<Good>)request.getAttribute("good05");
        if(goods==null){
            List<Good> goodList=goodFunction.getGoodByType(ty);
            request.setAttribute("good05",goodList);
            return goodList;
        }else {
            return goods;
        }
    }
    @RequestMapping("/WX")
    @ResponseBody
    List<Good> WX(String ty,HttpServletRequest request){

        List<Good> goods=(List<Good>)request.getAttribute("good06");
        if(goods==null){
            List<Good> goodList=goodFunction.getGoodByType(ty);
            request.setAttribute("good06",goodList);
            return goodList;
        }else {
            return goods;
        }
    }
    @RequestMapping("/ZW")
    @ResponseBody
    List<Good> ZW(String ty,HttpServletRequest request){

        List<Good> goods=(List<Good>)request.getAttribute("good07");
        if(goods==null){
            List<Good> goodList=goodFunction.getGoodByType(ty);
            request.setAttribute("good07",goodList);
            return goodList;
        }else {
            return goods;
        }
    }
//    @RequestMapping("/test")
//    @ResponseBody
//    List<Good> test() {
//        List<Good> goods = null;
//        goods = goodFunction.getAllGood();
//        return goods;
//    }
}
