package com.example.mistroe.mapper;

import com.example.mistroe.pojo.Buy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BuyMapper {
    int deleteByPrimaryKey(String idBuy);

    int insert(Buy record);

    Buy selectByPrimaryKey(String idBuy);

    List<Buy> selectAll();

    int updateByPrimaryKey(Buy record);


}