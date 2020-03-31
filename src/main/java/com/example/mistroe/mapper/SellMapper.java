package com.example.mistroe.mapper;

import com.example.mistroe.pojo.Sell;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SellMapper {
    int deleteByPrimaryKey(String idSell);

    int insert(Sell record);

    Sell selectByPrimaryKey(String idSell);

    List<Sell> selectAll();

    int updateByPrimaryKey(Sell record);
}