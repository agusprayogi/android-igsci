package com.sourcey.materiallogindemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Berita {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("isi_berita")
    @Expose
    private String isiBerita;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("tag")
    @Expose
    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getIsiBerita() {
        return isiBerita;
    }

    public void setIsiBerita(String isiBerita) {
        this.isiBerita = isiBerita;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
