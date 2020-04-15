package com.example.mistroe.mapper;

import com.example.mistroe.pojo.Buy;
import com.example.mistroe.pojo.Good;

import java.util.List;

public interface BuyMapper {
    int deleteByPrimaryKey(String idBuy);

    int insert(Buy record);

    Buy selectByPrimaryKey(String idBuy);

    List<Buy> selectAll();

    int updateByPrimaryKey(Buy record);

    int BuyGood(Buy buy);

    int Canl(String goodid);
}