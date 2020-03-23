package com.example.mistroe.mapper;

import com.example.mistroe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zlin
 * @date 2020/3/23 15:09
 */
@Mapper
public interface UserMapper {
    @Select("select id,name,pwd from user where name = #{name} and pwd = #{pwd}")
    User loginGO(String name, String pwd);
}
