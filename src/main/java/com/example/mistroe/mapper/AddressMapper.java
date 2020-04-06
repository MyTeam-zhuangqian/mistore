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
}