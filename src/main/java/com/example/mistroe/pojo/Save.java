package com.example.mistroe.pojo;

import java.io.Serializable;

public class Save implements Serializable {
    private String idSave;

    private String idUser;

    private String idGood;

    private static final long serialVersionUID = 1L;

    public String getIdSave() {
        return idSave;
    }

    public void setIdSave(String idSave) {
        this.idSave = idSave == null ? null : idSave.trim();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser == null ? null : idUser.trim();
    }

    public String getIdGood() {
        return idGood;
    }

    public void setIdGood(String idGood) {
        this.idGood = idGood == null ? null : idGood.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idSave=").append(idSave);
        sb.append(", idUser=").append(idUser);
        sb.append(", idGood=").append(idGood);
        sb.append("]");
        return sb.toString();
    }
}