package com.Model;

import java.util.List;

public class TeamResponse {
    private String pesan;
    private List<TeamModel> data;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<TeamModel> getData() {
        return data;
    }

    public void setData(List<TeamModel> data) {
        this.data = data;
    }
}
