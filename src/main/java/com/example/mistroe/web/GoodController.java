package com.example.mistroe.web;

import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.function.impl.GoodFunctionImpl;
import com.example.mistroe.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping("/test")
    @ResponseBody
    List<Good> test() {
        List<Good> goods = null;
        goods = goodFunction.getAllGood();
        return goods;
    }
}
