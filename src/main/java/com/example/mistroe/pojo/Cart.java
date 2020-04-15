package com.example.mistroe.pojo;

import java.io.Serializable;

public class Cart implements Serializable {
    private String idCar;

    private String idGood;

    private String idUser;

    private static final long serialVersionUID = 1L;

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar == null ? null : idCar.trim();
    }

    public String getIdGood() {
        return idGood;
    }

    public void setIdGood(String idGood) {
        this.idGood = idGood == null ? null : idGood.trim();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser == null ? null : idUser.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idCar=").append(idCar);
        sb.append(", idGood=").append(idGood);
        sb.append(", idUser=").append(idUser);
        sb.append("]");
        return sb.toString();
    }
}