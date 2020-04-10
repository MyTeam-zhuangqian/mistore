package com.example.mistroe.pojo;

import java.io.Serializable;

public class Good implements Serializable {
    private String idGood;

    private String img;

    private String description;

    private Double price;

    private String author;

    private String type;

    private static final long serialVersionUID = 1L;

    public String getIdGood() {
        return idGood;
    }

    public void setIdGood(String idGood) {
        this.idGood = idGood == null ? null : idGood.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        return "Good{" +
                "idGood='" + idGood + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}