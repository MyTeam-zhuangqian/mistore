package com.example.mistroe.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String idUser;

    private String name;

    private String pwd;

    private String nickname;

    private Date birthday;

    private Integer sex;

    private String headPortrait;

    private String usualAddress;

    private static final long serialVersionUID = 1L;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser == null ? null : idUser.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    public String getUsualAddress() {
        return usualAddress;
    }

    public void setUsualAddress(String usualAddress) {
        this.usualAddress = usualAddress == null ? null : usualAddress.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", headPortrait='" + headPortrait + '\'' +
                ", usualAddress='" + usualAddress + '\'' +
                '}';
    }
}