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

    List<Good> gatGoodByType(String ty);

    Good getGoodById(String goodid);

    List<Good> getCartGood(String idUser);

    List<Good> GetSave(String userid);

    List<Good> GetBuy(String idUser);

    List<Good> GetMyBuy(String userid);

    List<Good> SellWait(String userid);
}