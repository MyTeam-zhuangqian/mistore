package com.example.mistroe.web;

import com.example.mistroe.function.AddrFunction;
import com.example.mistroe.pojo.Address;
import com.example.mistroe.pojo.User;
import com.example.mistroe.util.Result;
import com.example.mistroe.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/Addr")
public class AddrController {

    @Autowired
    AddrFunction addrFunction;

    /**
    * @Description: 实现加载用户所有地址信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/get_addr")
    @ResponseBody
    Result get_addr(HttpServletRequest request){
        //System.out.println("come in ");
        User u=(User)request.getSession().getAttribute("user");
        //System.out.println(u);
        List<Address> addresses=addrFunction.getAddr(u.getIdUser());//加载用户地址信息，getAddr方法实现
        //下面代码为前端接口所需要返回的数据格式要求
        Result obj=new Result();
        obj.setData(addresses);
        obj.setMessage("");
        obj.setStatus(0);
        obj.setTotal(1);
        return obj;
    }


    /**
    * @Description: 更新用户地址信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/Update")
    @ResponseBody
    int UpAddr(String addr,String iphone,String idaddr){

        int i=addrFunction.UpAddr(addr,iphone,idaddr);//具体更新用户地址信息用UpAddr方法实现
        return i;
    }


    /**
    * @Description: 用户增加地址信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/Insert")
    @ResponseBody
    int Insert(String DZ,String tel,HttpServletRequest request){

        String idaddress= UUIDUtils.getUUIDAsString();
        User u=(User)request.getSession().getAttribute("user");
        int i=addrFunction.InsertAddr(DZ,tel,idaddress,u.getIdUser());//用户增加地址信息用InsertAddr方法实现
        return i;
    }

    /**
    * @Description: 删除某一个地址信息
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/Del")
    @ResponseBody
    int Del(String id){
        int i=addrFunction.Del(id);//实现用户删除某一个地址
        return i;
    }


    /**
    * @Description: 用户修改密码
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/ChangePwd")
    @ResponseBody
    int ChangePwd(String pwd,String newpwd,HttpServletRequest request){
        User u=(User)request.getSession().getAttribute("user");
        System.out.println(pwd);
        if(pwd.equals(u.getPwd())){
            int i=addrFunction.ChangePwd(newpwd,u.getIdUser());//实现用户修改密码
            return i;
        }else {
            return 0;
        }

    }

    /**
    * @Description: 用户充值
    * @Param:
    * @return:
    * @Author: 刘丹
    * @Date: 2020/4/26
    */
    @RequestMapping("/CZ")
    @ResponseBody
    int CZ(Float mon,HttpServletRequest request){
        Double money= (Double) request.getSession().getAttribute("money");
        request.getSession().removeAttribute("money");
        request.getSession().setAttribute("money",money+mon);//用户充值实现
        return 1;
    }
}
