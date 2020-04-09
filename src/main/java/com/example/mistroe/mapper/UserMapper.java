package com.example.mistroe.mapper;

import com.example.mistroe.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String idUser);

    int insert(User record);

    User selectByPrimaryKey(String idUser);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    User selectUserByName(@Param("name")String name);

    int ChangePwd(String newpwd, String idUser);
}