package com.example.mistroe.mapper;

import com.example.mistroe.pojo.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodMapper {
    int deleteByPrimaryKey(String idGood);

    int insert(Good record);

    Good selectByPrimaryKey(String idGood);

    List<Good> selectAll();

    int updateByPrimaryKey(Good record);
}