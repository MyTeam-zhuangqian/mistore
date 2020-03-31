package com.example.mistroe.pojo;

import java.io.Serializable;

public class GoodType implements Serializable {
    private String idType;

    private String goodType;

    private static final long serialVersionUID = 1L;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType == null ? null : goodType.trim();
    }
}