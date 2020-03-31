package com.example.mistroe.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private String idAddress;

    private String userId;

    private String address;

    private static final long serialVersionUID = 1L;

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress == null ? null : idAddress.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}