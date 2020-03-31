package com.example.mistroe.mapper;

import com.example.mistroe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String idUser);

    int insert(User record);

    User selectByPrimaryKey(String idUser);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByKey(@Param("key") String key, @Param("value") String value);

    User selectUserByName(@Param("name") String name);
}