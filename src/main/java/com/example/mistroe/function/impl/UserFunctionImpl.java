package com.example.mistroe.function.impl;


import com.example.mistroe.function.UserFunction;
import com.example.mistroe.mapper.UserMapper;
import com.example.mistroe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zlin
 * @date 2020/3/23 15:03
 */
@Service
public class UserFunctionImpl implements UserFunction {

    @Autowired
    UserMapper userMapper;

    @Override
    public User loginGO(String name, String pwd) {
        User user = null;
        user = userMapper.selectUserByName(name);
        if (user != null){
            if (pwd.equals(user.getPwd())){
                //user.setPwd("");

                return user;
            }
        }
        return null;
    }


}
