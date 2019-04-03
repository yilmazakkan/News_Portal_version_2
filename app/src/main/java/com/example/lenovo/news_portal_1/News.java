package com.example.lenovo.news_portal_1;

/**
 * Created by Lenovo on 18.12.2017.
 */

public class News {
    int id;
    String baslik,metin,kategori;
    byte [] image;

    public News(int id, String baslik, String metin, String kategori, byte[] image) {
        this.id = id;
        this.baslik = baslik;
        this.metin = metin;
        this.kategori = kategori;
        this.image = image;
    }

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getMetin() {
        return metin;
    }

    public void setMetin(String metin) {
        this.metin = metin;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
