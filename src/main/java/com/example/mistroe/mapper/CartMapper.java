package com.example.mistroe.mapper;

import com.example.mistroe.pojo.Cart;
import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(String idCar);

    int insert(Cart record);

    Cart selectByPrimaryKey(String idCar);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);

    int addCart(Cart cart);
}