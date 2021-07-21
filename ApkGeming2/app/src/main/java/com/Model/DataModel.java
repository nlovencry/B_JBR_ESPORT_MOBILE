package com.Model;

public class DataModel {
    private int id_event;
    private String nama_event, keterangan, gambar;

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNama_event() {
        return nama_event;
    }

    public void setNama_event(String nama_event) {
        this.nama_event = nama_event;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

}
