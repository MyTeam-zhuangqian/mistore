package com.example.mistroe.pojo;

import java.io.Serializable;

public class Buy implements Serializable {
    private String idBuy;

    private Integer isBuy;

    private Integer goodId;

    private static final long serialVersionUID = 1L;

    public String getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(String idBuy) {
        this.idBuy = idBuy == null ? null : idBuy.trim();
    }

    public Integer getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Integer isBuy) {
        this.isBuy = isBuy;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}