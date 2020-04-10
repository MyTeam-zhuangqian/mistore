package com.example.mistroe.function.impl;

import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.mapper.GoodMapper;
import com.example.mistroe.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zlin
 * @date 2020/3/31 11:47
 */
@Service
public class GoodFunctionImpl implements GoodFunction {
    @Autowired
    GoodMapper goodMapper;
    @Override
    public List<Good> getAllGood() {

        return goodMapper.selectAll();
    }

    @Override
    public List<Good> getGoodByType(String ty) {
        return goodMapper.gatGoodByType(ty);
    }
}
