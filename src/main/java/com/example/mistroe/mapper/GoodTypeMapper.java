package com.example.mistroe.mapper;

import com.example.mistroe.pojo.GoodType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodTypeMapper {
    int deleteByPrimaryKey(String idType);

    int insert(GoodType record);

    GoodType selectByPrimaryKey(String idType);

    List<GoodType> selectAll();

    int updateByPrimaryKey(GoodType record);
}