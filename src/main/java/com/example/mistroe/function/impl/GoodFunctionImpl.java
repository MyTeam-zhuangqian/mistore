package com.example.mistroe.function.impl;

import com.example.mistroe.function.GoodFunction;
import com.example.mistroe.mapper.*;
import com.example.mistroe.pojo.*;
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
    @Autowired
    SaveMapper saveMapper;
    @Autowired
    BuyMapper buyMapper;

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

    @Override
    public List<Good> getGoodByKey(String key) {
        key = "%"+key+"%";
        return goodMapper.selectGoodByKey(key);
    }

    @Override
    public Good getGoodById(String goodid) {
        return goodMapper.getGoodById(goodid);
    }

    @Override
    public int SaveCar(Save save) {
        return saveMapper.SaveCar(save);
    }

    @Override
    public List<Good> getCartGood(String idUser) {
        return goodMapper.getCartGood(idUser);
    }

    @Override
    public int BuyGood(Buy buy) {
        return buyMapper.BuyGood(buy);
    }

    @Override
    public List<Good> GetSave(String userid) {
        return goodMapper.GetSave(userid);
    }

    @Override
    public List<Good> GetBuy(String idUser) {
        return goodMapper.GetBuy(idUser);
    }

    @Override
    public List<Good> GetMyBuy(String userid) {
        return goodMapper.GetMyBuy(userid);
    }

    @Override
    public int Canl(String goodid) {
        return buyMapper.Canl(goodid);
    }

    @Override
    public int IsOk(String goodid) {
        return sellMapper.IsOk(goodid);
    }

    @Override
    public List<Good> SellWait(String userid) {
        return goodMapper.SellWait(userid);
    }

    @Override
    public List<Good> MyOk(String userid) {
        return goodMapper.MyOk(userid);
    }

    @Override
    public int Ok(String goodid) {
        return buyMapper.Ok(goodid);
    }

    @Override
    public List<Good> GetBuys(String userid) {
        return goodMapper.GetBuys(userid);
    }

    @Override
    public List<Good> Mysell(String userid) {
        return goodMapper.Mysell(userid);
    }

    @Override
    public List<Good> Mypub(String userid) {
        return goodMapper.Mypub(userid);
    }

}
