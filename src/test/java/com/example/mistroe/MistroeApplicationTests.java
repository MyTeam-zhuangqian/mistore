package com.example.mistroe;

import com.example.mistroe.mapper.UserMapper;
import com.example.mistroe.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MistroeApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> user=userMapper.selectAll();
        for (User u:user) {
            System.out.println(u);
        }
    }

}
