package com.example.mistroe.function;

import com.example.mistroe.pojo.Address;

import java.util.List;

public interface AddrFunction {

    List<Address> getAddr(String name);

    int UpAddr(String addr, String iphone, String idaddr);

    int InsertAddr(String dz, String tel,String idaddress, String idUser);

    int Del(String id);

    int ChangePwd(String newpwd, String idUser);
}
