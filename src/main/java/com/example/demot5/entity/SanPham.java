package com.example.demot5.entity;

import javax.persistence.*;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "tenSP")
    private String tenSP;
    @Column(name = "gia")
    private int gia;
    @Column(name = "theloai")
    private String theloai;
    @Column(name = "linkHA")
    private String linkHA;
    @Column(name = "luotmua")
    private int luotmua;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getLinkHA() {
        return linkHA;
    }

    public void setLinkHA(String linkHA) {
        this.linkHA = linkHA;
    }

    public int getLuotmua() {
        return luotmua;
    }

    public void setLuotmua(int luotmua) {
        this.luotmua = luotmua;
    }
}
