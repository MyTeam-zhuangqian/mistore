package com.example.mistroe.function;

import com.example.mistroe.pojo.Cart;

public interface CartFunction {
    int addCar(Cart cart);

    int selectCountByUser(String name);
}
