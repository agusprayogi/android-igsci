package com.sourcey.materiallogindemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatusReqBerita {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("person")
    @Expose
    private List<Berita> berita = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Berita> getPerson() {
        return berita;
    }

    public void setPerson(List<Berita> person) {
        this.berita = berita;
    }
}
