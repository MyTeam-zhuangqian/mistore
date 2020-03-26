package com.example.mistroe.web;

import com.example.mistroe.function.UserFunction;
import com.example.mistroe.pojo.Book;
import com.example.mistroe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlin
 * @date 2020/3/23 13:46
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserFunction userFunction;

    @RequestMapping("/login")
    String login(){
        return "login";
    }
    @RequestMapping("/index")
    String index(){
        return "index";
    }
    @RequestMapping("/Goods")
    String Goods(){return "Goods";}
    @RequestMapping("/sell")
    String sell(){ return "sell";}

    @RequestMapping("/login_go")
    @ResponseBody
    User loginGo(String name,String pwd){
        User user = null;
        user = userFunction.loginGO(name,pwd);
        if (user!=null){
            return user;
        }
        return null;
    }

    @RequestMapping("/test")
    @ResponseBody
    List<Book> test(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"中国古典文学四大名著（新课标） 中小学新课标必读，四大名著，经典原著权威改编，无障碍轻松阅读，影响学生",
                "img/goods1.jpg.jfif","72.80","（明) 罗贯中,(明)施耐庵, (明) 罗贯中（清）曹雪芹 著;富强 改编 /2016-07-20 /安徽教育出版社"));

        books.add(new Book(2,"中国古典文学四大名著（新课标） 中小学新课标必读，四大名著，经典原著权威改编，无障碍轻松阅读，影响学生",
                "img/goods1.jpg.jfif","72.80","（明) 罗贯中,(明)施耐庵, (明) 罗贯中（清）曹雪芹 著;富强 改编 /2016-07-20 /安徽教育出版社"));
        books.add(new Book(3,"中国古典文学四大名著（新课标） 中小学新课标必读，四大名著，经典原著权威改编，无障碍轻松阅读，影响学生",
                "img/goods1.jpg.jfif","72.80","（明) 罗贯中,(明)施耐庵, (明) 罗贯中（清）曹雪芹 著;富强 改编 /2016-07-20 /安徽教育出版社"));
        books.add(new Book(4,"中国古典文学四大名著（新课标） 中小学新课标必读，四大名著，经典原著权威改编，无障碍轻松阅读，影响学生",
                "img/goods1.jpg.jfif","72.80","（明) 罗贯中,(明)施耐庵, (明) 罗贯中（清）曹雪芹 著;富强 改编 /2016-07-20 /安徽教育出版社"));
        books.add(new Book(5,"中国古典文学四大名著（新课标） 中小学新课标必读，四大名著，经典原著权威改编，无障碍轻松阅读，影响学生",
                "img/goods1.jpg.jfif","72.80","（明) 罗贯中,(明)施耐庵, (明) 罗贯中（清）曹雪芹 著;富强 改编 /2016-07-20 /安徽教育出版社"));
        return books;
    }

}
