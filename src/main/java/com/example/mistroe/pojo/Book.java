package com.example.mistroe.pojo;

/**
 * @author zlin
 * @date 2020/3/26 18:36
 */
public class Book {
    Integer id;
    String description;
    String img;
    String price;
    String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(Integer id, String description, String img, String price, String author) {
        this.id = id;
        this.description = description;
        this.img = img;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
