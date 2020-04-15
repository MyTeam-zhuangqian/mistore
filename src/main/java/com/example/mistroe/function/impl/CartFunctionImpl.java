package com.example.mistroe.function.impl;

import com.example.mistroe.function.CartFunction;
import com.example.mistroe.mapper.CartMapper;
import com.example.mistroe.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartFunctionImpl implements CartFunction {

    @Autowired
    CartMapper cartMapper;

    @Override
    public int addCar(Cart cart) {
        return cartMapper.addCart(cart);
    }
}
