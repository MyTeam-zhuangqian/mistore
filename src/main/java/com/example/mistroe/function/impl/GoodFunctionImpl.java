package com.example.mistroe.function.impl;

import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.mapper.GoodMapper;
import com.example.mistroe.mapper.GoodTypeMapper;
import com.example.mistroe.mapper.SellMapper;
import com.example.mistroe.pojo.Good;
import com.example.mistroe.pojo.GoodType;
import com.example.mistroe.pojo.Sell;
import com.example.mistroe.util.UUIDUtils;
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
    @Autowired
    GoodTypeMapper goodTypeMapper;
    @Autowired
    SellMapper sellMapper;

    @Override
    public List<Good> getAllGood() {

        return goodMapper.selectAll();
    }

    @Override
    public List<Good> getGoodByType(String ty) {
        return goodMapper.gatGoodByType(ty);
    }

    @Override
    public List<GoodType> selectAllType() {
        return goodTypeMapper.selectAll();
    }

    @Override
    public int insert(Good good , String idUser) {
        good.setIdGood(UUIDUtils.getUUIDAsString());
        String img = "img/"+good.getImg();
        good.setImg(img);
        Sell sell = new Sell();
        sell.setIdSell(UUIDUtils.getUUIDAsString());
        sell.setGoodId(good.getIdGood());
        sell.setIsSell(0);
        sell.setUserId(idUser);
        if (sellMapper.insert(sell)==1){
            return goodMapper.insert(good);
        }else {
            return 0;
        }

    }
}
