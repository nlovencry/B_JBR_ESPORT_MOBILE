package com.Model;

import java.util.List;

public class ResponseJadwal {
    private String pesan;
    private List<JadwalModel> data;


    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<JadwalModel> getData() {
        return data;
    }

    public void setData(List<JadwalModel> data) {
        this.data = data;
    }
}
