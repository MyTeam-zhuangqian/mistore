package com.example.mistroe.web;

import com.example.mistroe.function.CartFunction;
import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.mapper.CartMapper;
import com.example.mistroe.pojo.*;
import com.example.mistroe.util.Result;
import com.example.mistroe.util.UUIDUtils;
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

    @Autowired
    CartFunction cartFunction;

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
    @RequestMapping("/getGood")
    @ResponseBody
    Good getGood(String goodid,HttpServletRequest request){
        Good good=goodFunction.getGoodById(goodid);
        if (good!=null){
            request.getSession().setAttribute("good",good);
            return good;
        }
        else {
            return good;
        }
    }
    @RequestMapping("/Cart")
    @ResponseBody
    int addCar(String goodid,HttpServletRequest request){
        if(((User)request.getSession().getAttribute("user"))==null)
        {
            return 3;
        }else {
            Cart cart = new Cart();
            cart.setIdCar(UUIDUtils.getUUIDAsString());
            cart.setIdGood(goodid);
            cart.setIdUser(((User) request.getSession().getAttribute("user")).getName());
            int i=cartFunction.addCar(cart);
            request.getSession().removeAttribute("cartCount");
            int cartCount = cartFunction.selectCountByUser(((User) request.getSession().getAttribute("user")).getName());
            request.getSession().setAttribute("cartCount",cartCount);
            return i;
        }
    }
    @RequestMapping("/Save")
    @ResponseBody
    int Save(String goodid,HttpServletRequest request){
        if(((User)request.getSession().getAttribute("user"))==null)
        {
            return 3;
        }else {
            Save save = new Save();
            save.setIdSave(UUIDUtils.getUUIDAsString());
            save.setIdGood(goodid);
            save.setIdUser(((User) request.getSession().getAttribute("user")).getName());
            int i=goodFunction.SaveCar(save);
            return i;
        }
    }
    @RequestMapping("/Buy")
    @ResponseBody
    int BuyGood(String goodid,String price,HttpServletRequest request){
        //System.out.println(goodid+" "+price);
        if(((User)request.getSession().getAttribute("user"))==null)
        {
            return 3;
        }else if (Float.parseFloat(price) >(Double)request.getSession().getAttribute("money")){
            return 2;
        }
        else {
            Buy buy=new Buy();
            buy.setGoodId(goodid);
            buy.setIdBuy(UUIDUtils.getUUIDAsString());
            buy.setIsBuy(0);
            buy.setUserId(((User) request.getSession().getAttribute("user")).getIdUser());
            int i=goodFunction.BuyGood(buy);
            if (i==1){
                Double mon=((Double)request.getSession().getAttribute("money"))-Float.parseFloat(price);
                request.getSession().removeAttribute("money");
                request.getSession().setAttribute("money",mon);
            }
             return i;
        }
    }
    @RequestMapping("/GetSave")
    @ResponseBody
    List<Good> GetSave(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getName();
        List<Good> goodList=goodFunction.GetSave(userid);
        return goodList;
    }
    @RequestMapping("/GetMyBuy")
    @ResponseBody
    List<Good> GetMyBuy(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.GetMyBuy(userid);
        return goodList;
    }
    @RequestMapping("/Canl")
    @ResponseBody
    int Canl(String goodid){
        int i=goodFunction.Canl(goodid);
        return i;
    }
    @RequestMapping("/IsOk")
    @ResponseBody
    int IsOk(String goodid){
        int i=goodFunction.IsOk(goodid);
        return i;
    }
    @RequestMapping("/SellWait")
    @ResponseBody
    List<Good> SellWait(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.SellWait(userid);
        return  goodList;
    }
    @RequestMapping("/MyOk")
    @ResponseBody
    List<Good> MyOk(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.MyOk(userid);
        return goodList;
    }
    @RequestMapping("/Ok")
    @ResponseBody
    int Ok(String goodid){
      int i=goodFunction.Ok(goodid);
      return i;
    }
    @RequestMapping("/GetBuys")
    @ResponseBody
    List<Good> GetBuys(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.GetBuys(userid);
        return goodList;
    }
    @RequestMapping("/Mypub")
    @ResponseBody
    List<Good> Mypub(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.Mypub(userid);
        return goodList;
    }
//    @RequestMapping("/test")
//    @ResponseBody
//    List<Good> test() {
//        List<Good> goods = null;
//        goods = goodFunction.getAllGood();
//        return goods;
//    }
}
