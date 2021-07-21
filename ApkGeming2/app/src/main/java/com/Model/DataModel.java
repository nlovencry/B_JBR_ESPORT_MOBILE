package com.Model;

public class DataModel {
    private int id_event;
    private String nama_event, keterangan, gambar, tgl_mulai_pendaftaran, tgl_akhir_pendaftaran, tanggal_mulai, tanggal_akhir, slot, price ;

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

    public String getTgl_mulai_pendaftaran() {
        return tgl_mulai_pendaftaran;
    }

    public void setTgl_mulai_pendaftaran(String tgl_mulai_pendaftaran) {
        this.tgl_mulai_pendaftaran = tgl_mulai_pendaftaran;
    }

    public String getTgl_akhir_pendaftaran() {
        return tgl_akhir_pendaftaran;
    }

    public void setTgl_akhir_pendaftaran(String tgl_akhir_pendaftaran) {
        this.tgl_akhir_pendaftaran = tgl_akhir_pendaftaran;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_akhir() {
        return tanggal_akhir;
    }

    public void setTanggal_akhir(String tanggal_akhir) {
        this.tanggal_akhir = tanggal_akhir;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
