package com.example.mistroe.pojo;

import java.io.Serializable;

public class Sell implements Serializable {
    private String idSell;

    private Integer isSell;

    private String goodId;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getIdSell() {
        return idSell;
    }

    public void setIdSell(String idSell) {
        this.idSell = idSell == null ? null : idSell.trim();
    }

    public Integer getIsSell() {
        return isSell;
    }

    public void setIsSell(Integer isSell) {
        this.isSell = isSell;
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
        sb.append(", idSell=").append(idSell);
        sb.append(", isSell=").append(isSell);
        sb.append(", goodId=").append(goodId);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}