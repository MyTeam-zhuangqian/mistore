package com.example.mistroe.web;

import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.pojo.Good;
import com.example.mistroe.util.Result;
import com.example.mistroe.util.UpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.mistroe.util.UpUtils.upfile;

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
    public Result upload(MultipartFile file, HttpServletRequest request){
        //System.out.println("图片上传================================================");
        Result result = new Result();
        try {
            UpUtils.upfile(file,request);
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


    @RequestMapping("/test")
    @ResponseBody
    List<Good> test() {
        List<Good> goods = null;
        goods = goodFunction.getAllGood();
        return goods;
    }
}
