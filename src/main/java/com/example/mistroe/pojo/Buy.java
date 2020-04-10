package com.example.mistroe.pojo;

import java.io.Serializable;

public class Buy implements Serializable {
    private String idBuy;

    private Integer isBuy;

    private String goodId;

    private String userId;

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

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idBuy=").append(idBuy);
        sb.append(", isBuy=").append(isBuy);
        sb.append(", goodId=").append(goodId);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}