package com.example.mistroe.web;

import com.example.mistroe.function.AddrFunction;
import com.example.mistroe.pojo.Address;
import com.example.mistroe.pojo.User;
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
    List<Address> get_addr(HttpServletRequest request){
        //System.out.println("come in ");
        User u=(User)request.getSession().getAttribute("user");
        //System.out.println(u);
        List<Address> addresses=addrFunction.getAddr(u.getIdUser());
        return addresses;
    }


}
