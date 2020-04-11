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

    @RequestMapping("/get_addr")
    @ResponseBody
    Result get_addr(HttpServletRequest request){
        //System.out.println("come in ");
        User u=(User)request.getSession().getAttribute("user");
        //System.out.println(u);
        List<Address> addresses=addrFunction.getAddr(u.getIdUser());
        Result obj=new Result();
        obj.setData(addresses);
        obj.setMessage("");
        obj.setStatus(0);
        obj.setTotal(1);
        return obj;
    }

    @RequestMapping("/Update")
    @ResponseBody
    int UpAddr(String addr,String iphone,String idaddr){

        int i=addrFunction.UpAddr(addr,iphone,idaddr);
        return i;
    }

    @RequestMapping("/Insert")
    @ResponseBody
    int Insert(String DZ,String tel,HttpServletRequest request){

        String idaddress= UUIDUtils.getUUIDAsString();
        User u=(User)request.getSession().getAttribute("user");
        int i=addrFunction.InsertAddr(DZ,tel,idaddress,u.getIdUser());
        return i;
    }
    @RequestMapping("/Del")
    @ResponseBody
    int Del(String id){
        int i=addrFunction.Del(id);
        return i;
    }

    @RequestMapping("/ChangePwd")
    @ResponseBody
    int ChangePwd(String pwd,String newpwd,HttpServletRequest request){
        User u=(User)request.getSession().getAttribute("user");
        System.out.println(pwd);
        if(pwd.equals(u.getPwd())){
            int i=addrFunction.ChangePwd(newpwd,u.getIdUser());
            return i;
        }else {
            return 0;
        }

    }
    @RequestMapping("/CZ")
    @ResponseBody
    int CZ(Float mon,HttpServletRequest request){
        Float money= (Float) request.getSession().getAttribute("money");
        request.getSession().setAttribute("money",money+mon);
        return 1;
    }
}
