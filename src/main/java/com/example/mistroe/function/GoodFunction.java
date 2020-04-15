package com.example.mistroe.function;

import com.example.mistroe.pojo.Buy;
import com.example.mistroe.pojo.Good;
import com.example.mistroe.pojo.GoodType;
import com.example.mistroe.pojo.Save;

import java.util.List;

/**
 * @author zlin
 * @date 2020/3/31 11:46
 */
public interface GoodFunction {
    public List<Good> getAllGood();

    List<Good> getGoodByType(String ty);

    List<GoodType> selectAllType();

    int insert(Good good,String idUser);

    List<Good> getGoodByKey(String key);


    Good getGoodById(String goodid);

    int SaveCar(Save save);

    List<Good> getCartGood(String idUser);

    int BuyGood(Buy buy);

    List<Good> GetSave(String userid);

    List<Good> GetBuy(String idUser);

    List<Good> GetMyBuy(String userid);

    int Canl(String goodid);

    int IsOk(String goodid);

    List<Good> SellWait(String userid);
}
