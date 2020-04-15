package com.example.mistroe.function.impl;


import com.example.mistroe.function.UserFunction;
import com.example.mistroe.mapper.UserMapper;
import com.example.mistroe.pojo.User;
import com.example.mistroe.util.UUIDUtils;
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

    @Override
    public int insert(User user) {
        user.setIdUser(UUIDUtils.getUUIDAsString());
        String img = "img/" + user.getHeadPortrait();
        user.setHeadPortrait(img);
        return userMapper.insert(user);
    }

    @Override
    public int updateHeadPortrait(User user) {
        return userMapper.updateHeadPortrait(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User selectUserById(String idUser) {
        User user = userMapper.selectByPrimaryKey(idUser);
        user.setPwd("");
        return user;
    }


}
