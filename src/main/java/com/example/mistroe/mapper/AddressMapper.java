package com.example.mistroe.mapper;

import com.example.mistroe.pojo.Address;
import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(String idAddress);

    int insert(Address record);

    Address selectByPrimaryKey(String idAddress);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);

    List<Address> getAddr(String name);

    int UpAddr(String addr, String iphone, String idaddr);

    int InsertAddr(String dz, String tel,String idaddress, String idUser);

    int Del(String id);

}