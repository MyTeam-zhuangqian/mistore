package com.example.mistroe.function;

import com.example.mistroe.pojo.Good;

import java.util.List;

/**
 * @author zlin
 * @date 2020/3/31 11:46
 */
public interface GoodFunction {
    public List<Good> getAllGood();

    List<Good> getGoodByType(String ty);
}
