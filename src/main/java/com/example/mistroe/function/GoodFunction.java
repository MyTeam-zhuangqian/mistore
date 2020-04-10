package com.example.mistroe.function;

import com.example.mistroe.pojo.Good;
import com.example.mistroe.pojo.GoodType;

import java.util.List;

/**
 * @author zlin
 * @date 2020/3/31 11:46
 */
public interface GoodFunction {
    public List<Good> getAllGood();

    List<GoodType> selectAllType();

    int insert(Good good,String idUser);
}
