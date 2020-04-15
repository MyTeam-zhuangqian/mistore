package com.example.mistroe.function;


import com.example.mistroe.pojo.User;

/**
 * @author zlin
 * @date 2020/3/23 14:59
 */

public interface UserFunction {

    User loginGO(String name, String pwd);


    int insert(User user);

    int updateHeadPortrait(User user);

    int update(User user);

    User selectUserById(String idUser);
}
