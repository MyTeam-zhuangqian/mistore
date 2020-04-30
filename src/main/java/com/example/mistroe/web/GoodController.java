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

    /**
    * @Description: 用户更换头像方法
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file, HttpServletRequest request) {
        //System.out.println("图片上传================================================");
        Result result = new Result();
        try {
            UpUtils.upfile(file, request);//实现图片上传在自定义的工具类
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

    /**
    * @Description: 实现发布商品
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/insert")
    @ResponseBody
    @Transactional //开启事务（开启事务的方法必须是public）
    public Result insert(Good good ,HttpServletRequest request) {
        User user= (User)request.getSession().getAttribute("user");
        int i = goodFunction.insert(good,user.getIdUser());//实现商品发布
        //以下代码为前端接口所需数据格式，同下面下面所有方法
        Result result = new Result();
        if (i == 1){
            result.setStatus(0);
        }else {
            result.setStatus(500);
            result.setMessage("网络繁忙！");
        }
        return result;
    }

    /**
    * @Description: 查询所有商品的分类
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/selectAllType")
    @ResponseBody
    Result selectAllType() {
        List<GoodType> goodTypes = null;
        goodTypes = goodFunction.selectAllType();//实现所有商品类型查询
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

    /**
    * @Description: 加载四六级商品信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/CE")
    @ResponseBody
    List<Good> CE(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//实现四六级商品信息查询
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 实现计算机专区商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/PC")
    @ResponseBody
    List<Good> PC(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//实现计算机商品查询具体方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 实现考证专区商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/KZ")
    @ResponseBody
    List<Good> KZ(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//考证专区商品信息查询具体方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 考公专区商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/KG")
    @ResponseBody
    List<Good> KG(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//考公专区商品信息查询具体方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 考研专区商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/KY")
    @ResponseBody
    List<Good> KY(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//实现考研专区商品查询具体方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 文学作品商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/WX")
    @ResponseBody
    List<Good> WX(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//具体实现文学作品商品信息查询方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 中外名著商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/ZW")
    @ResponseBody
    List<Good> ZW(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//实现中外名著商品信息查询具体方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 数学类型商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/SX")
    @ResponseBody
    List<Good> SX(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//实现数学类型商品信息查询具体方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 音体美类型商品信息查询
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/MU")
    @ResponseBody
    List<Good> MU(String ty,HttpServletRequest request){

        request.getSession().setAttribute("goods",null);
        List<Good> goods=goodFunction.getGoodByType(ty);//实现音体美类型商品信息查询具体方法
        request.getSession().setAttribute("goods",goods);
        return goods;
    }

    /**
    * @Description: 商品搜索
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/search")
    @ResponseBody
    Result search(String key ,HttpServletRequest request) {
        List<Good> goods = null;
        goods = goodFunction.getGoodByKey(key);//通过用户输入的关键字进行商品查询
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
    
    /** 
    * @Description: 加载某一个商品具体信息
    * @Param:  
    * @return:  
    * @Author: 刘丹
    * @Date: 2020/4/26 
    */ 
    @RequestMapping("/getGood")
    @ResponseBody
    Good getGood(String goodid,HttpServletRequest request){
        Good good=goodFunction.getGoodById(goodid);//根据商品id加载具体商品信息
        if (good!=null){
            request.getSession().setAttribute("good",good);
            return good;
        }
        else {
            return good;
        }
    }

    /**
    * @Description: 添加商品到购物车
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
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
            int i=cartFunction.addCar(cart);//添加商品到购物车具体实现方法
            request.getSession().removeAttribute("cartCount");
            int cartCount = cartFunction.selectCountByUser(((User) request.getSession().getAttribute("user")).getName());//添加成功之后实时更新购物车数量
            request.getSession().setAttribute("cartCount",cartCount);
            return i;
        }
    }

    /**
    * @Description: 收藏商品
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
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
            int i=goodFunction.SaveCar(save);//实现商品收藏
            return i;
        }
    }

    /**
    * @Description: 购买商品
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/Buy")
    @ResponseBody
    int BuyGood(String goodid,String price,HttpServletRequest request){
        //System.out.println(goodid+" "+price);
        if(((User)request.getSession().getAttribute("user"))==null)//if成立即用户未登录，返回请求登录
        {
            return 3;
        }else if (Float.parseFloat(price) >(Double)request.getSession().getAttribute("money")){//余额不足，购买失败返回
            return 2;
        }
        else {
            Buy buy=new Buy();
            buy.setGoodId(goodid);
            buy.setIdBuy(UUIDUtils.getUUIDAsString());
            buy.setIsBuy(0);
            buy.setUserId(((User) request.getSession().getAttribute("user")).getIdUser());
            int i=goodFunction.BuyGood(buy);//实现购买商品
            if (i==1){
                Double mon=((Double)request.getSession().getAttribute("money"))-Float.parseFloat(price);//购买成功更新账户余额
                request.getSession().removeAttribute("money");
                request.getSession().setAttribute("money",mon);
            }
             return i;
        }
    }

    /**
    * @Description: 加载用户收藏的商品信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/GetSave")
    @ResponseBody
    List<Good> GetSave(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getName();
        List<Good> goodList=goodFunction.GetSave(userid);//实现查询用户收藏的所有商品信息
        return goodList;
    }

    /**
    * @Description: 加载用户卖出的待发货的商品信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/GetMyBuy")
    @ResponseBody
    List<Good> GetMyBuy(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.GetMyBuy(userid);//实现查询用户卖出的待发货的商品信息
        return goodList;
    }

    /**
    * @Description: 卖家取消订单方法
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/Canl")
    @ResponseBody
    int Canl(String goodid){
        int i=goodFunction.Canl(goodid);//卖家取消订单实现
        return i;
    }

    /**
    * @Description: 卖家确认发货
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/IsOk")
    @ResponseBody
    int IsOk(String goodid){
        int i=goodFunction.IsOk(goodid);//卖家确认发货实现
        return i;
    }

    /**
    * @Description: 加载我卖出的待收货商品
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/SellWait")
    @ResponseBody
    List<Good> SellWait(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.SellWait(userid);//实现查询用户卖出的等待买家确认收货商品信息
        return  goodList;
    }

    /**
    * @Description: 加载我购买的未确认收货的商品信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/MyOk")
    @ResponseBody
    List<Good> MyOk(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.MyOk(userid);//加载用户买的未确认守护商品信息具体方法
        return goodList;
    }

    /**
    * @Description: 实现用户买到的商品确认收货操作
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/Ok")
    @ResponseBody
    int Ok(String goodid){
      int i=goodFunction.Ok(goodid);//实现商品确认收货操作
      return i;
    }

    /**
    * @Description: 加载用户已将买到的所有商品信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/GetBuys")
    @ResponseBody
    List<Good> GetBuys(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.GetBuys(userid);//查询用户买到的所有商品信息
        return goodList;
    }

    /**
    * @Description: 查询用户发布的商品信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/Mypub")
    @ResponseBody
    List<Good> Mypub(HttpServletRequest request){
        String userid=((User)request.getSession().getAttribute("user")).getIdUser();
        List<Good> goodList=goodFunction.Mypub(userid);//查询用户发布的商品信息
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
