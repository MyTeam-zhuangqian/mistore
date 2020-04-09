package com.example.mistroe.function.impl;

import com.example.mistroe.function.AddrFunction;
import com.example.mistroe.mapper.AddressMapper;
import com.example.mistroe.mapper.UserMapper;
import com.example.mistroe.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddFunctionImpl implements AddrFunction {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<Address> getAddr(String name) {
        List<Address> addresses=addressMapper.getAddr(name);

        return addresses;
    }

    @Override
    public int UpAddr(String addr, String iphone, String idaddr) {
        return addressMapper.UpAddr(addr,iphone,idaddr);
    }

    @Override
    public int InsertAddr(String dz, String tel,String idaddress, String idUser) {
        return addressMapper.InsertAddr(dz,tel,idaddress,idUser);
    }

    @Override
    public int Del(String id) {
        return addressMapper.Del(id);
    }

    @Override
    public int ChangePwd(String newpwd, String idUser) {
        return userMapper.ChangePwd(newpwd,idUser);
    }
}
