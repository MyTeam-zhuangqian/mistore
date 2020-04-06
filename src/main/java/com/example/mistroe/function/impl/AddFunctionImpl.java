package com.example.mistroe.function.impl;

import com.example.mistroe.function.AddrFunction;
import com.example.mistroe.mapper.AddressMapper;
import com.example.mistroe.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddFunctionImpl implements AddrFunction {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public List<Address> getAddr(String name) {
        List<Address> addresses=addressMapper.getAddr(name);
        return addresses;
    }
}
